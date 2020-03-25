package system;

import java.util.HashMap;

public class System
{
    public Memory memory = new Memory();

    public static class Memory
    {
        public static Memory reference = new Memory();

        protected HashMap<String, Object> map = new HashMap();

        public Memory()
        {
            Memory.reference = this;
        }

        public Object pull(String name)
        {
            return this.map.get(name);
        }

        public void push(String name, Object object)
        {
            this.map.put(name, object);
        }
    }

    public static class Database
    {
        public String name;

        public static Database database;

        public Database(String name)
        {
            Database.database = this;

            this.name = name;
        }
    }
}
