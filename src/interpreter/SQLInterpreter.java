package database.interpreter;

import bodhi.BodhiDatabase;
import database.SQLColumn;
import database.SQLDatabase;
import database.SQLTable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLInterpreter
{
    public BodhiDatabase bodhidatabase;

    public InterpreterResult result;

    public SQLInterpreter(BodhiDatabase bodhidatabase)
    {
        this.bodhidatabase = bodhidatabase;
    }

    public InterpreterResult interpret(String line)
    {
        line = line.strip();

        //

        if(line.startsWith("ADD DATABASE")) //e.g. ADD DATABASE '//citizens'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                this.bodhidatabase.databases.put(databasename, new SQLDatabase(databasename));
            }

            //

            return result;
        }
        else if(line.startsWith("ALTER DATABASE") && line.contains("ADD TABLE")) //e.g. ALTER DATABASE '//citizens' ADD TABLE '//ages'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                if(databasename != null)
                {
                    SQLDatabase database = this.bodhidatabase.databases.get(databasename);

                    if(database != null)
                    {
                        String tablename = matcher.group(2);

                        if(tablename != null)
                        {
                            database.tables.put(tablename, new SQLTable(tablename));
                        }
                        else return new InterpreterResult("No table name found.","No errors.");
                    }
                    else return new InterpreterResult("Database reference unexpectedly null.","No errors.");
                }
                else return new InterpreterResult();
            }

            //

            return result;
        }
        else if(line.startsWith("ALTER DATABASE") && line.contains("ADD TABLE") && line.contains("ADD COLUMN")) //e.g. ALTER DATABASE '//citizens' ALTER TABLE '//employees' ADD COLUMN '//social security number'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                SQLDatabase database = this.bodhidatabase.databases.get(databasename);

                if(database != null)
                {
                    String tablename = matcher.group(2);

                    if(tablename != null)
                    {
                        SQLTable table = database.tables.get(tablename);

                        if(table != null)
                        {
                            String columnname = matcher.group(3);

                            if(columnname != null)
                            {
                                table.columns.put(new SQLColumn(columnname));
                            }
                            else return new InterpreterResult("No column name found.","No errors.");
                        }
                        else return new InterpreterResult("Table reference unexpectedly null.","No errors.");
                    }
                    else return new InterpreterResult("No table name found.","No errors.");
                }
                else return new InterpreterResult("Database reference unexpectedly null.","No errors.");
            }

            //

            return result;
        }
        else if(line.startsWith("INSERT INTO TABLE") && line.contains("WHERE TABLE EQUALS") && line.contains("WHERE COLUMN EQUALS")) //e.g. INSERT INTO DATABASE '//microsoft' WHERE TABLE EQUALS '//employees' WHERE COLUMN EQUALS '//social security number' VALUE '123-456-7890'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                SQLDatabase database = this.bodhidatabase.databases.get(databasename);

                if(database != null)
                {
                    String tablename = matcher.group(2);

                    if(tablename != null)
                    {
                        SQLTable table = database.tables.get(tablename);

                        if(table != null)
                        {
                            String columnname = matcher.group(3);

                            if(columnname != null)
                            {
                                SQLColumn column = table.columns.get(columnname);

                                if(column != null) //Add support for File object types
                                {
                                    String value = matcher.group(4);

                                    database.insert(table, column, value);
                                }
                                else return new InterpreterResult("Column reference was unexpectedly null.","No errors.");
                            }
                            else return new InterpreterResult("No column name found.","No errors.");
                        }
                        else return new InterpreterResult("Table reference unexpectedly null.","No errors.");
                    }
                    else return new InterpreterResult("No table name found.","No errors.");
                }
                else return new InterpreterResult("Database reference unexpectedly null.","No errors.");
            }
            else return new InterpreterResult("No matches found.","No errors.");
            //

            return result;
        }

        return new InterpreterResult("No matches.","No errors.");
    }
}
