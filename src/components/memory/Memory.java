package components.memory;

import java.util.HashMap;

public class Memory
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

    public Boolean non_null(String name)
    {
        return Memory.reference.pull(name)==null;
    }

    public Boolean exists(String name) throws Exception
    {
        boolean result = Memory.reference.pull(name)==null;

        if(result==true) throw new Exception();

        return false;
    }

    public Boolean exists(String name, String exception) throws Exception
    {
        boolean result = Memory.reference.pull(name)==null;

        if(result==true) throw new Exception(exception);

        return false;
    }
}
