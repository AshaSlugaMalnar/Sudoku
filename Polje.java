
public class Polje {

    int indeks;
    int indexkvadrat;
    int idVrstice;
    int idStolpca;
    int idKvadrata;
    String kandidati;

    Polje[] vrstica = new Polje[9];
    Polje[] stolpec = new Polje[9];
    Polje[] kvadrat = new Polje[9];

    private static Polje[][] tabela = new Polje[9][9];
    private static Polje[] tabelaVvrsti = new Polje[81];
    private static String[][] stringTabela = new String[9][9];

    public static String[][] Init(String tekst) {
         for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!tekst.substring(j * 9 + i, j * 9 + i + 1).equals(".")) {
                    stringTabela[i][j] = tekst.substring(j * 9 + i, j * 9 + i + 1);
                } else {
                    stringTabela[i][j] = "123456789";
                }
            }
        }
        
        
        
        
       for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Polje newPolje = new Polje();
                newPolje.indeks = i * 9 + j;
                newPolje.idVrstice = i;
                newPolje.idStolpca = j;
                newPolje.idKvadrata = ((i / 3) * 3) + (j / 3);

                if (stringTabela[j][i].equals("")) {
                    newPolje.kandidati = "123456789";
                } else {
                    newPolje.kandidati = stringTabela[j][i];
                }

                // stringTabela[i][j] = newPolje.kandidati;
                tabela[i][j] = newPolje;
                tabelaVvrsti[newPolje.indeks] = newPolje;

            }
       }
            
        Polje newPolje = new Polje();
       

        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newPolje = tabela[i][j];
                for (int k = 0; k < 9; k++) {
                    newPolje.vrstica[k] = tabela[k][j];
                    newPolje.stolpec[k] = tabela[i][k];
                }
                int k=0;
                for (int v = 0; v < 81; v++) {
                   
                    if(tabelaVvrsti[v].idKvadrata==newPolje.idKvadrata){
                        
                        newPolje.kvadrat[k]=tabelaVvrsti[v];
                        
                        k++;
                                
                    }
                }
            }
        }

        UpdateTable();
        return stringTabela;

    }

    static void UpdateTable() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringTabela[i][j] = tabela[i][j].kandidati;
            }
        }
    }
    
     public static String[][] ClearTable() {
       for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabela[i][j].kandidati="123456789";
            }}
         
      UpdateTable();
      return stringTabela;
        
        
     }
        

    public static String[][] Solve1() {
        for (Polje temp : tabelaVvrsti) {
            if (temp.kandidati.length() == 1) {
                for (Polje vrstaPolje : temp.vrstica) {
                    if (vrstaPolje.indeks != temp.indeks) {
                        vrstaPolje.kandidati = vrstaPolje.kandidati.replace(temp.kandidati, "");
                    }
                }
                for (Polje stolpecPolje : temp.stolpec) {
                    if (stolpecPolje.indeks != temp.indeks) {
                        stolpecPolje.kandidati = stolpecPolje.kandidati.replace(temp.kandidati, "");
                    }
                }
                for (Polje kvadratPolje : temp.kvadrat) {
                 if (kvadratPolje.indeks != temp.indeks) {
                 kvadratPolje.kandidati = kvadratPolje.kandidati.replace(temp.kandidati, "");
                 }
                 }
            }

        }
        UpdateTable();
        return stringTabela;

    }
    
    

    public static String[][] Solve2() {
        for (Polje tempPolje : tabelaVvrsti) {
            if (tempPolje.kandidati.length() > 1) {
                for (String kandidat : tempPolje.kandidati.split("")) {
                    boolean onlyOne = true;
                    for (Polje vrstaPolje : tempPolje.vrstica) {
                        if (vrstaPolje.indeks != tempPolje.indeks) {
                            if (vrstaPolje.kandidati.contains(kandidat)) {
                                onlyOne = false;
                            }
                        }

                    }
                    if (onlyOne == true) {
                        tempPolje.kandidati = kandidat;

                    }

                    onlyOne = true;
                    for (Polje stolpecPolje : tempPolje.stolpec) {
                        if (stolpecPolje.indeks != tempPolje.indeks) {
                            if (stolpecPolje.kandidati.contains(kandidat)) {
                                onlyOne = false;
                            }
                        }

                    }

                    if (onlyOne == true) {
                        tempPolje.kandidati = kandidat;

                    }
                    onlyOne = true;
                     for (Polje kvadratPolje : tempPolje.kvadrat) {
                     if (kvadratPolje.indeks != tempPolje.indeks) {
                     if (kvadratPolje.kandidati.contains(kandidat)) {
                     onlyOne = false;
                     }
                     }

                     }
                    
                     if (onlyOne == true) {
                     tempPolje.kandidati = kandidat;

                     }

                }

            }

        }
        UpdateTable();
        return stringTabela;

    }
}
