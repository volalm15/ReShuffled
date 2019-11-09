package serial.requests;

/**
 *
 * @author volalm15
 */
public class RequestAutoDeal extends Request {

    public RequestAutoDeal(int value) {
        super();
        createRequestFrame("A" + value);
    }

    @Override
    public void handleResponse(byte[] receivedFrame) {
        super.handleResponse(receivedFrame);
        
        System.out.println(receivedFrame);
    }

    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName()).append('{');
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
}
