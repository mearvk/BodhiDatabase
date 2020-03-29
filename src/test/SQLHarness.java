package test;

import structures.Queue;
import structures.SQLString;
import system.System;

public class SQLHarness
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

            queue.add(new SQLString("CREATE DATABASE weather"));

            queue.add(new SQLString("USE weather"));

            queue.add(new SQLString("CREATE TABLE reports (ReportID int, Summary varchar(255), Date date)"));
        }
    }

    public static class Test_003
    {
        public Test_003()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE equipment"));

            queue.add(new SQLString("USE equipment"));

            queue.add(new SQLString("CREATE TABLE golf (ObjectID int, Brand varchar(255), Model varchar(255))"));
        }
    }

    public static class Test_004
    {
        public Test_004()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE alcohol"));

            queue.add(new SQLString("USE alcohol"));

            queue.add(new SQLString("CREATE TABLE alcohol (ObjectID int, Brand varchar(255), Make varchar(255))"));
        }
    }

    public static class Test_005
    {
        public Test_005()
        {
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

            queue.add(new SQLString("CREATE DATABASE hospital"));

            queue.add(new SQLString("USE hospital"));

            queue.add(new SQLString("CREATE TABLE patients (PersonID int, Firstname varchar(255), Lastname varchar(255))"));
        }
    }

}
