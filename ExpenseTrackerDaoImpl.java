package com.vanshikaexpense.msbaexpensetracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class ExpenseTrackerDaoImpl implements ExpenseTrackerDao{
    
        @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertRecord(Expense emp) {
        entityManager.persist(emp);
    }
    @Override
    public List<Expense> findAllRecords() {
        TypedQuery<Expense> typedQuery = entityManager.createQuery("from Expense", Expense.class);
        return typedQuery.getResultList();
    }

    @Override
    public Expense findById(int id) {
        Expense exp = entityManager.find(Expense.class, id);
        return exp;
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        Expense expenseToDelete = entityManager.find(Expense.class, id);
        if (expenseToDelete != null) {
            entityManager.remove(expenseToDelete);
        }
    }
    @Override
    @Transactional
    public void updateRecord(int id,Expense expensetoUpdate) {
        Expense exp = entityManager.find(Expense.class, id);
        exp.setDate(expensetoUpdate.getDate());
        exp.setExpense((expensetoUpdate.getExpense()));
        exp.setName(expensetoUpdate.getName());
        exp.setNote(expensetoUpdate.getNote());
        exp.setUrl(expensetoUpdate.getUrl());
        entityManager.merge(exp);
    }
}
