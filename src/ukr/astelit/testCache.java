package ukr.astelit;

import net.sf.ehcache.CacheManager;

public class testCache {

    public static void main(String[] args) {
	CacheManager manager1 = CacheManager.newInstance("ehcache.xml");
	//CacheManager manager2 = CacheManager.newInstance("src/config/ehcache2.xml");
	String[] cacheNamesForManager1 = manager1.getCacheNames();
	//String[] cacheNamesForManager2 = manager2.getCacheNames();
	for (String name:cacheNamesForManager1) {
	    System.out.println(name);
	}

    }

}
