/**
 * @Auther: WSS
 * @Date:
 * @Description 整型、char类型所对应的包装类，在自动装箱时，对于-128~127之间的值会进行缓存处理，
 *              其目的是提高效率。
 *              缓存处理的原理为：如果数据在-128~127这个区间，那么在类加载时就已经为该区间的每个数值创建了对象，
 *              并将这256个对象存放到一个名为cache的数组中。每当自动装箱过程发生时(或者手动调用valueOf()时)，
 *              就会先判断数据是否在该区间，如果在则直接获取数组中对应的包装类对象的引用，
 *              如果不在该区间，则会通过new调用包装类的构造方法来创建对象。
 *
 *              Integer类相关源码如下：
 *
 *              public static Integer valueOf(int i) {
 *                  if (i >= IntegerCache.low && i <= IntegerCache.high)
 *                      return IntegerCache.cache[i + (-IntegerCache.low)];
 *              return new Integer(i);
 *              }
 *
 *              IntegerCache类为Integer类的一个静态内部类，仅供Integer类使用。
 *              一般情况下 IntegerCache.low为-128，IntegerCache.high为127，
 *              IntegerCache.cache为内部类的一个静态属性
 */
public class TestCache {
    public static void main(String[] args) {
        Integer in1 = -128;
        Integer in2 = -128;
        System.out.println(in1 == in2);//true 因为123在缓存范围内
        System.out.println(in1.equals(in2));//true
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);//false 因为1234不在缓存范围内
        System.out.println(in3.equals(in4));//true

    }
}
