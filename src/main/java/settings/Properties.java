package settings;

import java.util.Optional;

public class Properties {
        /** url rbp-organization-service на который будут отправляться запросы */
        public static String serviceUrl = Optional.ofNullable(System.getenv("serviceUrl"))
                        .orElse("http://localhost:8080");

        /** количество пользователей с которых будет стартовать нагрузка */
        public static double startUsersPerSec = Double.parseDouble(
                        Optional.ofNullable(System.getenv("startUsersPerSec")).orElse("0"));

        /**
         * количество запросов на ступени стабилизации которые будет поддерживать
         * Gatling
         */
        public static double usersPerSec = Double.parseDouble(
                        Optional.ofNullable(System.getenv("usersPerSec")).orElse("10"));

        /**
         * Продолжительность времени во время которой будет осуществлен переходс одной
         * ступени на другую
         */
        public static long rampUpDuration = Long
                        .parseLong(
                                        Optional.ofNullable(System.getenv("rampUpDuration")).orElse("60"));

        /** Продолжительность ступени стабилизации интенсивности */
        public static long testDuration = Long.parseLong(
                        Optional.ofNullable(
                                        System.getenv("testDuration")).orElse("600"));

        /** Количество ступеней нагрузки */
        public static int loadSteps = Integer.parseInt(
                        Optional.ofNullable(System.getenv("loadSteps")).orElse("5"));

        /** наименование используемой симуляции */
        public static String test = String.format("simulations.%s",
                        Optional.ofNullable(System.getenv("test")).orElse("Debug"));
}
