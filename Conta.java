public class Conta{
    public int numero;
    public double saldo;
    public double limite = 100;
    public double[] extrato = new double[10];
    public int no = 0;//no = número de operações
    public boolean permissão = true;
    
    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }
    public Conta(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
        }
    
    public void sacar(double valor){
        if(permissão){
            if(valor > saldo+limite){
                System.out.printf("saldo insuficiente\n");
            }else if(valor <= 0){
                System.out.printf("valor inserido é invalido\n");
            }else{
                saldo= saldo-valor;
                extrato[no] = -valor;
                no++;
                checa_no();
                permissão = checa_no();
            }
        }
    }
    
    public void depositar(double valor){
        if(permissão){
            if(valor <= 0 ){
                System.out.printf("valor inserido é invalido\n");
            }else{
                saldo = saldo+valor;
                extrato[no] = valor;
                no++;
                checa_no();
                permissão = checa_no();
            }
        }  
    }
    
    
    public void transferir(Conta destino, double valor){
        if(permissão){
            if(valor > saldo){
            System.out.printf("saldo insuficiente\n");
            }else if(valor <=0){
            System.out.printf("valor inserido é invalido\n");
            }else{
                saldo = saldo - valor;
                destino.depositar(valor);
                extrato[no]= -valor;
                no++;
                checa_no();
                permissão = checa_no();
            }
        }
    }
    
    public void ver_extrato(){
        for(int i=0; i<no; i++){
            System.out.printf("%.2f\n",extrato[i]);
        }
    }
    
    public boolean checa_no() {
        if(no == extrato.length){
            System.out.printf("limite de operações atingido\n");
            return false;
        }else{
            return true;
            }
        }
}
