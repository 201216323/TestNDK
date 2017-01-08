package bruce.chang.javacallc;

/**
 * Created by: BruceChang
 * Date on : 2017/1/6.
 * Time on: 10:24
 * Progect_Name:TestNDK
 * Source Github：
 * Description:
 */

public class Jni {

    static {
        System.loadLibrary("javacallc");
    }

    /**
     * 求两个数字的和
     *
     * @param x
     * @param y
     * @return
     */
    public native int sum(int x, int y);

    /**
     * 将两个字符串拼接后返回
     *
     * @param s
     * @return
     */
    public native String sayHello(String s);

    /**
     * 将数组中的每个元素增加10
     *
     * @param intArray
     * @return
     */
    public native int[] increaseArrayEles(int[] intArray);

    /**
     *  应用: 检查密码是否正确, 如果正确返回200, 否则返回400
     "123456"
     * @param pwd
     * @return
     */
    public native int checkPwd(String pwd);
}
