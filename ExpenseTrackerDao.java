package com.vanshikaexpense.msbaexpensetracker;

import java.util.List;


public interface ExpenseTrackerDao {
    public void insertRecord(Expense emp);

    public Expense findById(int id);

    public List<Expense> findAllRecords();

    public void updateRecord(int id, Expense exp);

    public void deleteRecord(int id);

}
