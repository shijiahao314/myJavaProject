package sjh.example;

class MainTest {

    @org.junit.jupiter.api.Test
    void insert() {
        Main main = new Main();
        main.insert();
        main.print();
    }
}