class greet {

    interface byebye {
        void byebye();
    }

    class hello implements byebye {

        abstract static class anotherone {

            public abstract void sound();

            public void sound(String str) {
                System.out.println("sound " + str);
            }
        }

        @Override
        public void byebye() {
            System.out.println("bye bye from greet");
        }
    }

    class tata extends greet.hello.anotherone {

        @Override
        public void sound() {
            System.out.println("Sound from tata");
        }
    }
}

public class InnerInterfaceAbstract {

    public static void main(String[] args) {
        greet g = new greet();
        greet.hello gh = g.new hello();
        greet.tata gt = g.new tata();

        // greet.hello.anotherone gha = new greet.tata();
        gh.byebye();
        gt.sound();
        gt.sound("swishhhh");
    }
}
