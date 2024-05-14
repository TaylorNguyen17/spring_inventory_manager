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
            InhousePart base = new InhousePart(0, "base", 499.99, 900, 0, 999);
            partRepository.save(base);

            InhousePart seat = new InhousePart(1, "seat", 99.99, 900, 0, 999);
            partRepository.save(seat);

            InhousePart sidewall = new InhousePart(2, "sidewall", 199.99, 900, 0, 999);
            partRepository.save(sidewall);

            InhousePart cushion = new InhousePart(3, "cushion", 89.99, 900, 0 ,999);
            partRepository.save(cushion);

            OutsourcedPart connector = new OutsourcedPart(100, "connector", 24.99, 900, 0, 999, "Modular Milling Co");
            outsourcedPartRepository.save(connector);
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
