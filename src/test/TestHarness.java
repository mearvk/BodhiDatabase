package test;

import structures.Queue;
import structures.SQLString;
import system.System;

public class TestHarness
{
    public Test_001 test_001;

    public Test_002 test_002;

    public Test_003 test_003;

    public Test_004 test_004;

    public Test_005 test_005;

    //

    public static class Test_001
    {
        public Test_001()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE company"));

            queue.add(new SQLString("USE company"));

            queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
        }
    }

    public static class Test_002
    {
        public Test_002()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE company"));

            queue.add(new SQLString("USE company"));

            queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
        }
    }

    public static class Test_003
    {
        public Test_003()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE company"));

            queue.add(new SQLString("USE company"));

            queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
        }
    }

    public static class Test_004
    {
        public Test_004()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE company"));

            queue.add(new SQLString("USE company"));

            queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
        }
    }

    public static class Test_005
    {
        public Test_005()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE company"));

            queue.add(new SQLString("USE company"));

            queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
        }
    }

}
