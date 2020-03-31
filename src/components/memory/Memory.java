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

    public Object pull(String name) throws Exception
    {
        boolean result = this.map.get(name)==null;

        if(result==false) return this.map.get(name);

        else throw new Exception();
    }

    public void push(String name, Object object)
    {
        this.map.put(name, object);
    }

    public Boolean non_null(String name) throws Exception
    {
        return Memory.reference.pull(name)==null;
    }

    public Boolean exists(String bodhi) throws Exception
    {
        boolean result = Memory.reference.pull(bodhi)==null;

        if(result==true) throw new Exception();

        return true;
    }

    public Boolean exists(String name, String exception) throws Exception
    {
        boolean result = Memory.reference.pull(name)==null;

        if(result==true) throw new Exception(exception);

        return false;
    }
}
