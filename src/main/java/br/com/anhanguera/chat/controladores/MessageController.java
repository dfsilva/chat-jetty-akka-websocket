package br.com.anhanguera.chat.controladores;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MessageController extends WebSocketAdapter {

    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        System.out.println("Conexao estabelecida ");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    getSession().getRemote().sendString("Mensagem "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
//        MessagingLogic.getInstance().setOffline(currentUser.username);

//        this.session = null;

        System.err.println("Close connection " + statusCode + ", " + reason);

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
