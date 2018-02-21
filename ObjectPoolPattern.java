
Interface Reusable {
	
	public void run();

    public String getClassName();
}


public class Object1 implements Reusable {

    private String className;

    public Object1()
    {
      this.classname="Object1";
    }
	
	@Override
	public void run() {
	    System.out.println("Object1 is running");
	}

	@Override
	public String getClassName() {

		return this.classname;
	}
}

public class Object2 implements Reusable {

    private String className;

    public Object2()
    {
      this.classname="Object2";
    }
	
	@Override
	public void run() {
	    System.out.println("Object2 is running");
	}

	@Override
	public String getClassName() {

		return this.classname;
	}
}


public class ObjectPool {

	private ObjectPool objectPool;
	private Map<String,Resuable> objectPoolMap;
	private int max_pool_size;
	private int current_pool_size;

	private ObjectPool() {

	}

	private setMaxPoolSize(int size) {
		this.max_pool_size = size;
	}

	private setCurrentPoolSize(int size) {
		this.current_pool_size = size;
	}

	private getCurrentPoolSize() {

		return this.current_pool_size;
	}

	private getMaxPoolSize() {

		return this.max_pool_size;
	}
    
    public ObjectPool getInstance() {
    	if(objectPool == null) {
    		objectPool = new ObjectPool();
    		objectPool.setMaxPoolSize(5);
    		objectPoolMap.put("object1", new Object1());
    		objectPoolMap.put("Object2", new Object2());
    		objectPool.setCurrentPoolSize(2);
    	}
    	return objectPool;
    }

    public Reusable acquireReusable(String className) {
    	// checks if the map , already contains the given Object.
    	// If so, removes from Map and returns it to Client.
    	Resuable resuable;
    	if(objectPoolMap.contains(className))
    	{
    	    resuable = objectPoolMap.get(className);
    		objectPoolMap.remove(className);
    	}
    	// So, object is not there, so we can create a new Object , if the size of pool is not filled.
    	else {
    		if(getCurrentPoolSize < getMaxPoolSize()) {
    			// creates an Object of reference Resuable.
                // incraeasse the currentPoolsize
    			objectPoolMap.put(className, resuable);
    		}
    		else {
    			throw Exception("Pool doesnt have the Object and it is at its limit");
    		}
    	}
        return resuable;
    }

    public void releaseReusable(Resuable resuable) {
    	// if ObjectPool, already contains an instance of it, 
    	//no need to maintain and need to check Pool Size too
    	if(!objectPoolMap.contains(className) && (getCurrentPoolSize < getMaxPoolSize())) {
    		objectPoolMap.put(className, resuable);
    		//incraese the current pool size
    	}
    }
}