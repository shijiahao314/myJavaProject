package sjh.example.concurrent;

public class WaitNotifyExample {

    private static class DataBuffer {
        private String data;
        private boolean isEmpty = true;

        public synchronized void put(String data) {
            while (!isEmpty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.data = data;
            this.isEmpty = false;
            notifyAll();
        }

        public synchronized String take() {
            while (isEmpty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            String result = this.data;
            this.isEmpty = true;
            notifyAll();
            return result;
        }
    }

    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                buffer.put("Data " + i);
                System.out.println("Produced: Data " + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String data = buffer.take();
                System.out.println("Consumed: " + data);
            }
        });

        producer.start();
        consumer.start();
    }
}
