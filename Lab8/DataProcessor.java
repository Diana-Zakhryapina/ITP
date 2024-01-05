package Lab8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Аннотация может быть применена только к методам
@Retention(RetentionPolicy.RUNTIME) // Определяет как долго аннотация должна быть сохранена
                                    // @DataProcessor будет доступна во время выполнения программы
public @interface DataProcessor {} // Объявление аннотации
