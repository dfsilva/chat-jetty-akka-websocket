package br.com.anhanguera.chat.controladores;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class MessageController extends WebSocketAdapter {

    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        System.out.println("Conexao estabelecida ");
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
//        MessagingLogic.getInstance().setOffline(currentUser.username);

//        this.session = null;

        System.err.println("Close connection "+statusCode+", "+reason);

        super.onWebSocketClose(statusCode, reason);
    }
    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);

//        MessagingLogic.getInstance().receiveText(this, message);
    }
//    @Override
//    public void receiveText(String text) throws Exception {
////        if (session != null && session.isOpen()) {
////            session.getRemote().sendString(text);
////        }
//    }
//    @Override
//    public void setCurrentUser(User user) {
//        this.currentUser = user;
//    }
//    @Override
//    public void disconnect(int status, String reason) {
//
//        session.close(status, reason);
//        disconnect(status, reason);
//    }
}
