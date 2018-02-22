
import java.util.*;
import java.lang.*;
import java.io.*;


interface Reusable {
    
    public void run();

    public String getClassName();
}


 class Object1 implements Reusable {

    private String className;

    public Object1()
    {
      this.className="Object1";
    }
    
    @Override
    public void run() {
        System.out.println("Object1 is running");
    }

    @Override
    public String getClassName() {

        return this.className;
    }
}

 class Object2 implements Reusable {

    private String className;

    public Object2()
    {
      this.className="Object2";
    }
    
    @Override
    public void run() {
        System.out.println("Object2 is running");
    }

    @Override
    public String getClassName() {

        return this.className;
    }
}


 class ObjectPool {

    private static ObjectPool objectPool = null;
    private static Map<String,Reusable> objectPoolMap = new HashMap<String,Reusable>();
    private static int max_pool_size;
    private static int current_pool_size;

    private ObjectPool() {

    }

    private void setMaxPoolSize(int size) {
        this.max_pool_size = size;
    }

    private void setCurrentPoolSize(int size) {
        this.current_pool_size = size;
    }

    private int getCurrentPoolSize() {

        return this.current_pool_size;
    }

    private int getMaxPoolSize() {

        return this.max_pool_size;
    }
    
    public static ObjectPool getInstance() {
        if(objectPool == null) {
            objectPool = new ObjectPool();
            objectPool.setMaxPoolSize(2);
            objectPoolMap.put("Object1", new Object1());
            objectPoolMap.put("Object2", new Object2());
            objectPool.setCurrentPoolSize(2);
        }
        return objectPool;
    }

    public Reusable acquireReusable(String className) throws Exception{
        Reusable resuable;
        if(objectPoolMap.containsKey(className))
        {
            resuable = objectPoolMap.get(className);
            objectPoolMap.remove(className);
            setCurrentPoolSize(getCurrentPoolSize()-1);
        }
        else {
            if(getCurrentPoolSize() < getMaxPoolSize()) {
                resuable = createObject(className);
                objectPoolMap.put(className, resuable);
                setCurrentPoolSize(getCurrentPoolSize()+1);
            }
            else {
                throw new Exception("Pool doesnt have the Object and it is at its limit");
            }
        }
        return resuable;
    }

    public void releaseReusable(Reusable resuable) {
        // if ObjectPool, already contains an instance of it, 
        //no need to maintain and need to check Pool Size too
        System.out.println("ObjectPool is getting added objects"+resuable.getClassName());
        if(!objectPoolMap.containsKey(resuable.getClassName()) && (getCurrentPoolSize() < getMaxPoolSize())) {
            objectPoolMap.put(resuable.getClassName(), resuable);
            setCurrentPoolSize(getCurrentPoolSize()+1);
        }
    }

    private Reusable createObject(String className) {

        System.out.println("Create Object called for class with Name:"+className);

        switch(className) {
            case "Object1" :
            return new Object1();
            case "Object2" :
            return new Object2();
            default :
            return null;
        }
    }
}


class ObjectPoolPatternDemo {

    public static void main(String args[]) throws Exception {

        ObjectPool objectPool = ObjectPool.getInstance();
        Reusable resuable1 =   objectPool.acquireReusable("Object1");
        Reusable resuable2 =   objectPool.acquireReusable("Object2");
        Reusable resuable3 =   objectPool.acquireReusable("Object1");
        Reusable resuable4 =   objectPool.acquireReusable("Object2");
        objectPool.releaseReusable(resuable1);
        objectPool.releaseReusable(resuable2);
    }
}