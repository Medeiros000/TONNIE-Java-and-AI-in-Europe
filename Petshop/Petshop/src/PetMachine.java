public class PetMachine {
  private boolean clean;

  private int water;

  private int shampoo;

  private Pet pet;

  public PetMachine() {
    this.clean = true;
    this.water = 30;
    this.shampoo = 10;
  }

  public void takeAShower() {
    if (this.pet == null) {
      System.out.println("Coloque o pet na máquina para iniciar o banho");
      return;
    }
    this.water -= 10;
    this.shampoo -= 2;
    this.pet.setClean(true);
    System.out.println("O pet " + this.pet.getName() + " está limpo");
  }

  public void addWater() {
    if (this.water == 30) {
      System.out.println("A capacidade de água da máquina está no máximo");
    }
    this.water += 2;
  }

  public void addShampoo() {
    if (this.water == 30) {
      System.out.println("A capacidade de shampoo da máquina está no máximo");
    }
    this.shampoo += 2;
  }

  public int getWater() {
    return this.water;
  }

  public int getShampoo() {
    return this.shampoo;
  }

  public boolean hasPet() {
    return this.pet != null;
  }

  public void setPet(Pet pet) {
    if (!this.clean) {
      System.out.println("A máquina está suja, para colocar o pet é necessário limpar");
    }
    if (this.hasPet()) {
      System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento");
      return;
    }
    this.pet = pet;
  }

  public void removePet() {
    if (this.pet == null){
      System.out.println("Não tem pet na máquina");
      return;
    }
    this.clean = this.pet.isClean();
    System.out.println("O pet " + this.pet.getName() + " foi tirado da máquina");
    this.pet = null;
  }

  public void wash() {
    this.water -= 10;
    this.shampoo -= 2;
    this.clean = true;
    System.out.println("A máquina foi limpa");
  }
}
