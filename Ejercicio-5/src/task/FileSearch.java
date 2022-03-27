package task;

import java.io.File;

public class FileSearch implements Runnable{
    //Declaramos el path inicial para la búsqueda
    private String initPath;
    //Declaramos el nombre del archivo que va a ser buscado
    private String fileName;
    public FileSearch(String initPath, String fileName){
        //Asignamos los parametros a las variables con los mismos nombres en el objeto
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run(){

        //Declaramos un nuevo objeto File y le pasamos como parámetro el path en el que tiene que buscar
        File file = new File(initPath);
        //Consultamos si file es un directorio
        if (file.isDirectory()){
            try{
                //En caso de serlo, lo pasamos como parámetro para la función directoryProcess(File file)
                directoryProcess(file);
            }
            catch (InterruptedException e){
                //Se imprime por pantalla que la búsqueda fue interrumpida, si se tiente una excepción
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
                cleanResources();
            }
        }
    }

    //Se utiliza para limpiar los recursos
    private void cleanResources(){

    }

    private void directoryProcess(File file) throws InterruptedException{
        //Se crea una variable File, que se utiliza para recorrer los directorios
        File list[] = file.listFiles();

        //Se verifica que la lista no sea nula
        if (list != null){
            for (int i = 0; i < list.length; i++){
                //Se consulta si es un directorio
                if (list[i].isDirectory()){
                    /*
                        En caso de serlo, se manda a la función directoryProcess(File file), el objeto de la clase list
                        en la posición i
                     */
                    directoryProcess(list[i]);
                }
                else {
                    /*
                        En caso de no serlo, se manda a la función fileProcess(File file), el objeto de la clase list
                        en la posición i
                     */
                    fileProcess(list[i]);
                }
            }
        }

        //Se consulta si el hilo fue interrumpido
        if (Thread.interrupted()){
            //En caso de serlo, se lanza una excepción
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException{
        //Se verifica que el nombre sea el mismo
        if (file.getName().equals(fileName)){
            //Se imprime por pantalla el path del archivo
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        //Se consulta si el hilo fue interrumpido
        if (Thread.interrupted()){
            //En caso de serlo, se lanza una excepción
            throw new InterruptedException();
        }
    }
}
