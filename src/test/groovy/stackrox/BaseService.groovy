class BaseService {
    private static ThreadLocal<String> whatAmIDoing = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Behave the default way";
        }
    };

    public static String whatAreYouDoing() {
        return whatAmIDoing.get()
    }

    public static void doThisInstead(String somethingToDo) {
        whatAmIDoing.set(somethingToDo)
    }
}
