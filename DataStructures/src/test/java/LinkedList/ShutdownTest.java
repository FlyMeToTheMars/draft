package LinkedList;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/31 5:49 下午
 * @Version 1.0
 **/
public class ShutdownTest {

    public static void main(String[] args) {
        System.out.println("开始");

        for (int i = 0; i < 1000000000; i++) {
            System.out.println("repeat");
        }

        // 当使用 kill pid 或者 kill -15 pid的时候这个部分是会执行后才关闭程序的
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("关闭");
            }
        });
    }
}
