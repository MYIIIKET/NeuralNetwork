package Util;

import Objects.Element;

public class CollisionChecker extends Thread {

    public void run() {
        while (true) {
            int size = Stock.elements.size();
            Element e1, e2;
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    e1 = Stock.elements.get(i);
                    e2 = Stock.elements.get(j);
                    if (e1.collidesWith(e2)) {
                        e1.destroy();
                    }
                }
            }
        }
    }

    public void start() {
        this.setDaemon(true);
        super.start();
    }
}
