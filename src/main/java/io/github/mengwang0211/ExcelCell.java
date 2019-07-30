package io.github.mengwang0211;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * The <code>ExcelCell</code><br>
 * 数值型的栏位只能使用Double
 *
 * @author wmlucas.cn @gmail.com
 * @version 1.1, 添加了专用于验证的子注解 :Valid
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelCell {
    /**
     * 顺序 default 100
     *
     * @return index int
     */
    int index();

    /**
     * 当值为null时要显示的值 default StringUtils.EMPTY
     *
     * @return defaultValue string
     */
    String defaultValue() default "";

    /**
     * 用于验证
     *
     * @return valid valid
     */
    Valid valid() default @Valid();

    /**
     * Valid
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Valid {
        /**
         * 必须与in中String相符,目前仅支持String类型
         *
         * @return e.g. {"key","value"}
         */
        String[] in() default {};

        /**
         * 是否允许为空,用于验证数据 default true
         *
         * @return allowNull boolean
         */
        boolean allowNull() default true;

        /**
         * Apply a "greater than" constraint to the named property
         *
         * @return gt double
         */
        double gt() default Double.NaN;

        /**
         * Apply a "less than" constraint to the named property
         *
         * @return lt double
         */
        double lt() default Double.NaN;

        /**
         * Apply a "greater than or equal" constraint to the named property
         *
         * @return ge double
         */
        double ge() default Double.NaN;

        /**
         * Apply a "less than or equal" constraint to the named property
         *
         * @return le double
         */
        double le() default Double.NaN;
    }
}
