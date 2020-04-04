package test;

import components.parser.Parser;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;

public class SQLHarness
{
    public Test_001 test_001;

    public Test_002 test_002;

    public Test_003 test_003;

    public Test_004 test_004;

    public Test_005 test_005;

    public Test_006 test_006;

    //

    public static class Test_001
    {
        public Test_001()
        {
            try
            {
                Queue<SQLString> queue = Parser.reference.thread.queue;

                queue.add(new SQLString("CREATE DATABASE company"));

                queue.add(new SQLString("USE company"));

                queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Test_002
    {
        public Test_002()
        {
            try
            {
                Queue<SQLString> queue = Parser.reference.thread.queue;

                queue.add(new SQLString("CREATE DATABASE weather"));

                queue.add(new SQLString("USE weather"));

                queue.add(new SQLString("CREATE TABLE reports (ReportID int, Summary varchar(255), Date date)"));
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Test_003
    {
        public Test_003()
        {
            try
            {
                Queue<SQLString> queue = Parser.reference.thread.queue;

                queue.add(new SQLString("CREATE DATABASE equipment"));

                queue.add(new SQLString("USE equipment"));

                queue.add(new SQLString("CREATE TABLE golf (ObjectID int, Brand varchar(255), Model varchar(255))"));
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Test_004
    {
        public Test_004()
        {
            try
            {
                Queue<SQLString> queue = Parser.reference.thread.queue;;

                queue.add(new SQLString("CREATE DATABASE alcohol"));

                queue.add(new SQLString("USE alcohol"));

                queue.add(new SQLString("CREATE TABLE alcohol (ObjectID int, Brand varchar(255), Make varchar(255))"));
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Test_005
    {
        public Test_005()
        {
            try
            {
                Queue<SQLString> queue = Parser.reference.thread.queue;

                queue.add(new SQLString("CREATE DATABASE hospital"));

                queue.add(new SQLString("USE hospital"));

                queue.add(new SQLString("CREATE TABLE patients (PersonID int, Firstname varchar(255), Lastname varchar(255))"));
            }
            catch(Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Test_006
    {
        public Test_006()
        {
            try
            {
                Queue<SQLString> queue = Parser.reference.thread.queue;

                queue.add(new SQLString("CREATE DATABASE reports"));

                queue.add(new SQLString("USE reports"));

                queue.add(new SQLString("CREATE TABLE daily (ReportID int, Report varchar(65536), Firstname varchar(255), Lastname varchar(255))"));
            }
            catch(Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }
}
