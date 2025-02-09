import Proxy.ProxySiteHandler;

public class Main {
    public static void main(String[] args){
        ProxySiteHandler proxy = new ProxySiteHandler();

        proxy.addBlockedSite("www.blocked.com");

        proxy.redirect("www.google.com");
        proxy.redirect("www.blocked.com");
    }
}
