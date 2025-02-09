package Proxy;

public class RealSiteHandler implements URLHandler{

    @Override
    public void redirect(String URL) {
        System.out.println("Redirecting to website: " + URL);
    }
}
