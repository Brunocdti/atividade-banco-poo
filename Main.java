public class Main {
    public static void main(String[] args) {
        Conta usuario = new Conta(1001, 2000);
        System.out.println(usuario);
        Conta terceiro = new Conta(10, 0);
        usuario.sacar(500);
         System.out.println(usuario);
        usuario.depositar(0);
        usuario.transferir(terceiro, 500);
         System.out.println(usuario);
         System.out.println(terceiro);
        usuario.ver_extrato();
    }
}
