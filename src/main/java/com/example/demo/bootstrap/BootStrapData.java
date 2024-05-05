package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long partCount = partRepository.count();
        long productCount = productRepository.count();

        if (partCount == 0) {
            InhousePart base = new InhousePart();
            base.setName("base");
            base.setInv(900);
            base.setPrice(499.99);
            base.setPartId(0);
            partRepository.save(base);

            InhousePart seat = new InhousePart();
            seat.setName("seat");
            seat.setInv(900);
            seat.setPrice(99.99);
            base.setPartId(1);
            partRepository.save(seat);

            InhousePart sidewall = new InhousePart();
            sidewall.setName("sidewall");
            sidewall.setInv(900);
            sidewall.setPrice(199.99);
            sidewall.setPartId(2);
            partRepository.save(sidewall);

            InhousePart cushion = new InhousePart();
            cushion.setName("cushion");
            cushion.setInv(900);
            cushion.setPrice(89.99);
            cushion.setPartId(3);
            partRepository.save(cushion);

            OutsourcedPart connector = new OutsourcedPart();
            connector.setName("connector");
            connector.setInv(900);
            connector.setPrice(24.99);
            connector.setCompanyName("Modular Milling Co");
            connector.setId(100);
            partRepository.save(connector);
        }



       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if (productCount == 0) {
            Product ss = new Product("single seater", 1289.94, 20);
            Product ls = new Product("love seat", 2204.89, 20);
            Product ot =  new Product("ottoman", 599.98, 20);
            Product so =  new Product("sofa", 3119.84, 20);
            Product lo = new Product("lounger", 1714.92, 20);
            productRepository.save(ss);
            productRepository.save(ls);
            productRepository.save(ot);
            productRepository.save(so);
            productRepository.save(lo);
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
