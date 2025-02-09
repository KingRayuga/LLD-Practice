package Proxy;

import java.util.HashSet;
import java.util.Set;

public class ProxySiteHandler implements URLHandler{

    private RealSiteHandler realSiteHandler;
    private final Set<String> blockedSite = new HashSet<>();

    public void addBlockedSite(String URL){
        blockedSite.add(URL);
    }

    public void removeBlockedSite(String URL){
        blockedSite.remove(URL);
    }

    private static class ProxyHelper{
        final static RealSiteHandler INSTANCE = new RealSiteHandler();
    }

    @Override
    public void redirect(String URL) {
        if(blockedSite.contains(URL)){
            System.out.println("the URL is blocked");
            return;
        }
        ProxyHelper.INSTANCE.redirect(URL);
    }
}
