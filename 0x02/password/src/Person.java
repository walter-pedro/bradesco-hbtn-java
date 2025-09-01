public class Person {

    public boolean checkUser(String username) {
        return username.length() > 7
                && !contemCaracterEspecial(username);
    }

    public boolean checkPassword(String password) {
        return password.length() > 7
                && contemCaracterEspecial(password)
                && contemNumero(password)
                && contemLetraMaiuscula(password);
    }

    private boolean contemCaracterEspecial(String string) {
        return string.matches(".*[^a-zA-Z0-9 ].*");
    }

    private boolean contemNumero(String string) {
        return string.matches(".*[0-9].*");
    }

    private boolean contemLetraMaiuscula(String string) {
        return string.matches(".*[A-Z].*");
    }
}
