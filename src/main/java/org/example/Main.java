package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager em = emf.createEntityManager();

        try {
            // Persistir una nueva entidad Person
            em.getTransaction().begin();

            //Se crea la factura

            /*
            Categoria perecedero = Categoria.builder()
                    .denominacion("Perecederos")
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacion("Lácteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            Articulo articulo1 = Articulo.builder()
                    .denominacion("Leche")
                    .cantidad(150)
                    .precio(1500)
                    .build();

            Articulo articulo2 = Articulo.builder()
                    .denominacion("Lavandina 1L")
                    .cantidad(200)
                    .precio(2000)
                    .build();

            articulo1.getCategorias().add(perecedero);
            articulo1.getCategorias().add(lacteos);
            articulo2.getCategorias().add(limpieza);

            perecedero.getArticulos().add(articulo1);
            lacteos.getArticulos().add(articulo1);
            limpieza.getArticulos().add(articulo2);

            Cliente cliente1 = Cliente.builder()
                    .nombre("Pedro")
                    .apellido("Vasquez")
                    .dni(42568745)
                    .build();
            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("San Martin")
                    .numero(250)
                    .build();
            cliente1.setDomicilio(domicilio1);

            Factura factura1 = Factura.builder()
                    .fecha("2024-09-05")
                    .numero(120)
                    .build();

            factura1.setCliente(cliente1);

            DetalleFactura linea1 = DetalleFactura.builder()
                    .articulo(articulo1)
                    .cantidad(2)
                    .subtotal(3000)
                    .build();

            DetalleFactura linea2 = DetalleFactura.builder()
                    .articulo(articulo2)
                    .cantidad(5)
                    .subtotal(10000)
                    .build();

            factura1.getFacturas().add(linea1);
            factura1.getFacturas().add(linea2);
            factura1.setTotal(13000);

             */



            //actualiza factura al cambiar su numero de factura

            Factura factura1 = em.find(Factura.class,1L);
           factura1.setNumero(14);


           //al crear la factura usamos el siguiente comando
            //em.persist(factura1);

            //al actualizar factura utilizamos el siguiento comando
            //em.merge(factura1);

            //al eliminar factura
            em.remove(factura1);

            em.flush();
            em.getTransaction().commit();


        }catch (Exception e){

            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Factura");}

        // Cerrar el EntityManager y el EntityManagerFactory
      em.close();
        emf.close();
    }
}
