
package com.aelcorporation.krishipatra.domain.mock;

import com.aelcorporation.krishipatra.model.CenterRepository;
import com.aelcorporation.krishipatra.model.entities.Product;
import com.aelcorporation.krishipatra.model.entities.ProductCategoryModel;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


public class FakeWebServer {

    private static FakeWebServer fakeServer;

    public static FakeWebServer getFakeWebServer() {

        if (null == fakeServer) {
            fakeServer = new FakeWebServer();
        }
        return fakeServer;
    }

    void initiateFakeServer() {

        addCategory();

    }

    public void addCategory() {

        ArrayList<ProductCategoryModel> listOfCategory = new ArrayList<ProductCategoryModel>();

        listOfCategory
                .add(new ProductCategoryModel(
                        "Vegetable Farming",
                        "Vegetable Farming Items",
                        "5%",
                        "https://agrifarmingtips.com/wp-content/uploads/2017/08/Organic-farming-vegetable-farming-1.jpg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Poultry Farming",
                        "Poultry Farming Items",
                        "5%",
                        "https://dohanews.co/wp-content/uploads/2017/10/chicken-2584740_1920.jpg"));

        CenterRepository.getCenterRepository().setListOfCategory(listOfCategory);
    }

    public void getAllElectronics() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // Ovens
        productlist
                .add(new Product(
                        "Shovel",
                        "IFB 17PMMEC1 17 L Shovel",
                        "Shovels, although slightly bulky, truly are a tool you do not want to do without. They can be driven into the ground to turn soils, dig up plants, transplant, mix, cut through roots, or anything else you feel you need to get some leverage on. A good shovel will last you years to come and also come in a variety of shapes and sizes for the specific jobs you need them for.",
                        "500",
                        "10",
                        "450",
                        "0",
                        "https://images.homedepot-static.com/productImages/ead1895a-7772-4424-bd73-0856a18c7605/svn/hdx-shovels-2531800-64_1000.jpg",
                        "shovel_1"));

        productlist
                .add(new Product(
                        "Shovel",
                        "Bajaj 1701MT 17 L Shovel",
                        "Shovels, although slightly bulky, truly are a tool you do not want to do without. They can be driven into the ground to turn soils, dig up plants, transplant, mix, cut through roots, or anything else you feel you need to get some leverage on.",
                        "500",
                        "10",
                        "450",
                        "0",
                        "https://shop.coronatoolsusa.com/pub/media/catalog/product/cache/image/1000x1320/e9c3970ab036de70892d86c6d221abfe/s/s/ss60000_lrg.jpg",
                        "shovel_2"));

        productlist
                .add(new Product(
                        "Shovel",
                        "Whirlpool MW 25 BG 25 L Shovel",
                        "Shovels, although slightly bulky, truly are a tool you do not want to do without. They can be driven into the ground to turn soils, dig up plants, transplant, mix, cut through roots, or anything else you feel you need to get some leverage on.",
                        "800",
                        "10",
                        "720",
                        "0",
                        "https://www.ortovox.com/us/shop/media/image/thumbnail/shovel-pro-light-hl-21205-hires5bb206fb2ca74_1200x600.jpg",
                        "shovel_3"));

        productlist
                .add(new Product(
                        "Shovel",
                        "Morphy Richards 25CG 25 L Shovel",
                        "A good shovel will last you years to come and also come in a variety of shapes and sizes for the specific jobs you need them for. \n",
                        "300",
                        "10",
                        "270",
                        "0",
                        "https://images.homedepot-static.com/productImages/ead1895a-7772-4424-bd73-0856a18c7605/svn/hdx-shovels-2531800-64_1000.jpg",
                        "shovel_4"));

        productlist
                .add(new Product(
                        "Shovel",
                        "IFB 25SC4 25 L Shovel",
                        "A good shovel will last you years to come and also come in a variety of shapes and sizes for the specific jobs you need them for. \n",
                        "400",
                        "10",
                        "360",
                        "0",
                        "https://media.treehugger.com/assets/images/2018/01/pusher_snow_shovel.jpg",
                        "shovel_5"));

        productMap.put("Shovel", productlist);

        ArrayList<Product> tvList = new ArrayList<Product>();

        // TV
        tvList.add(new Product(
                "Electric weed eater",
                "Vu 80cm (32) Electric weed eater",
                "An electric weed eater truly is a helpful tool to have in your vegetable garden. It can be used to clear pathways, cut back weeds from around the beds, and even edge your garden to keep weeds and grasses from invading.",
                "16000",
                "12",
                "13990",
                "0",
                "https://images.homedepot-static.com/productImages/36aa9f87-9f35-4eaf-b8c4-919eabaa0590/svn/weed-eater-electric-string-trimmers-967695201-64_1000.jpg",
                "we_1"));

        tvList.add(new Product(
                "Electric weed eater",
                "Ultra Light Electric weed eater",
                "An electric weed eater truly is a helpful tool to have in your vegetable garden. It can be used to clear pathways, cut back weeds from around the beds, and even edge your garden to keep weeds and grasses from invading.",
                "17000",
                "12",
                "13990",
                "0",
                "https://www.lawncare.org/wp-content/uploads/weed-eater.jpg",
                "we_2"));

        tvList.add(new Product(
                "Electric weed eater",
                "Light Electronic Weed Eater",
                "An electric weed eater truly is a helpful tool to have in your vegetable garden. It can be used to clear pathways, cut back weeds from around the beds, and even edge your garden to keep weeds and grasses from invading.",
                "18000",
                "12",
                "13990",
                "0",
                "https://www.supremeten.com/wp-content/uploads/2017/12/Corded-electric-weed-eater.jpg",
                "we_3"));

        tvList.add(new Product(
                "Electric weed eater",
                "Ultra Ultra light Elecronic weed Eater",
                "An electric weed eater truly is a helpful tool to have in your vegetable garden. It can be used to clear pathways, cut back weeds from around the beds, and even edge your garden to keep weeds and grasses from invading.",
                "16000",
                "12",
                "13990",
                "0",
                "https://content.propertyroom.com/listings/sellers/seller1/images/origimgs/weed-eater-snap-n-go-sg11-electric-grass-trimmer-1_5420171831503583701.jpg",
                "we_4"));

        tvList.add(new Product(
                "Electric weed eater",
                "Vu 80cm Electric weed eater",
                "An electric weed eater truly is a helpful tool to have in your vegetable garden. It can be used to clear pathways, cut back weeds from around the beds, and even edge your garden to keep weeds and grasses from invading.",
                "16000",
                "12",
                "13990",
                "0",
                "https://images.homedepot-static.com/productImages/36aa9f87-9f35-4eaf-b8c4-919eabaa0590/svn/weed-eater-electric-string-trimmers-967695201-64_1000.jpg",
                "we_5"));

        productMap.put("Electric weed eater", tvList);

        productlist = new ArrayList<Product>();

        // Vaccum Cleaner
        productlist
                .add(new Product(
                        "Hand trowel ",
                        "Hand trowel",
                        "A hand trowel may be the most popular, and well-used gardening tool ever. This handheld miniature shovel is amazingly helpful to reach into tight spaces, dig small holes for planting, help dig up and transplant seedlings, and allow you to work close to your plants. It is also amazingly helpful for potted plants and container gardening, especially if you have any raised beds.",
                        "2699",
                        "10",
                        "2566",
                        "0",
                        "https://images-na.ssl-images-amazon.com/images/I/71N8W8Wmx9L._SX466_.jpg",
                        "handtrowel1"));

        productlist
                .add(new Product(
                        "Hand trowel ",
                        "Ultra Hand trowel",
                        "A hand trowel may be the most popular, and well-used gardening tool ever. This handheld miniature shovel is amazingly helpful to reach into tight spaces, dig small holes for planting, help dig up and transplant seedlings, and allow you to work close to your plants. It is also amazingly helpful for potted plants and container gardening, especially if you have any raised beds.",
                        "2699",
                        "10",
                        "2566",
                        "0",
                        "https://images-na.ssl-images-amazon.com/images/I/71N8W8Wmx9L._SX466_.jpg",
                        "handtrowel2"));

        productlist
                .add(new Product(
                        "Hand trowel",
                        "Hand trowel Ultra-Light",
                        "A hand trowel may be the most popular, and well-used gardening tool ever. This handheld miniature shovel is amazingly helpful to reach into tight spaces, dig small holes for planting, help dig up and transplant seedlings, and allow you to work close to your plants. It is also amazingly helpful for potted plants and container gardening, especially if you have any raised beds.",
                        "2699",
                        "10",
                        "2566",
                        "0",
                        "https://images-na.ssl-images-amazon.com/images/I/71N8W8Wmx9L._SX466_.jpg",
                        "handtrowel3"));

        productlist
                .add(new Product(
                        "Hand trowel",
                        "Hand trowel Light-Weighted",
                        "A hand trowel may be the most popular, and well-used gardening tool ever. This handheld miniature shovel is amazingly helpful to reach into tight spaces, dig small holes for planting, help dig up and transplant seedlings, and allow you to work close to your plants. It is also amazingly helpful for potted plants and container gardening, especially if you have any raised beds.",
                        "2699",
                        "10",
                        "2566",
                        "0",
                        "https://images-na.ssl-images-amazon.com/images/I/71N8W8Wmx9L._SX466_.jpg",
                        "handtrowel4"));


        productlist
                .add(new Product(
                        "Hand trowel ",
                        "UltraPerformance Hand Trowel",
                        "A hand trowel may be the most popular, and well-used gardening tool ever. This handheld miniature shovel is amazingly helpful to reach into tight spaces, dig small holes for planting, help dig up and transplant seedlings, and allow you to work close to your plants. It is also amazingly helpful for potted plants and container gardening, especially if you have any raised beds.",
                        "2699",
                        "10",
                        "2566",
                        "0",
                        "https://images-na.ssl-images-amazon.com/images/I/71N8W8Wmx9L._SX466_.jpg",
                        "handtrowel5"));

        productMap.put("Hand Trowel", productlist);


        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllFurnitures() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // Table
        productlist
                .add(new Product(
                        "Incubator",
                        "Royal Oak Engineered Incubator",
                        "Incubator is a device used to grow and maintain microbiological cultures or cell cultures. The incubator maintains optimal temperature, humidity and other conditions such as the CO (CO2) and oxygen content of the atmosphere inside.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://assets.fishersci.com/TFS-Assets/CCG/product-images/F308960~p.eps-650.jpg",
                        "incubator_1"));

        productlist
                .add(new Product(
                        "Incubator",
                        "Royal Oak Incubator",
                        "Incubator is a device used to grow and maintain microbiological cultures or cell cultures. The incubator maintains optimal temperature, humidity and other conditions such as the CO (CO2) and oxygen content of the atmosphere inside.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://s3.amazonaws.com/cdn.lehmans.com/images/large/344462.jpg",
                        "incubator_2"));

        productlist
                .add(new Product(
                        " Incubator",
                        "Royal Incubator",
                        "Incubator is a device used to grow and maintain microbiological cultures or cell cultures. The incubator maintains optimal temperature, humidity and other conditions such as the CO (CO2) and oxygen content of the atmosphere inside.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://5.imimg.com/data5/EE/PB/MY-19346435/laboratory-incubator-500x500.jpg",
                        "incubator_3"));

        productlist
                .add(new Product(
                        " Incubator",
                        "Royal Oak Engineered Wood Incubator",
                        "Incubator is a device used to grow and maintain microbiological cultures or cell cultures. The incubator maintains optimal temperature, humidity and other conditions such as the CO (CO2) and oxygen content of the atmosphere inside.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://s3.amazonaws.com/cdn.lehmans.com/images/large/344462.jpg",
                        "incubator_4"));

        productlist
                .add(new Product(
                        " Incubator",
                        "Incubator",
                        "Incubator is a device used to grow and maintain microbiological cultures or cell cultures. The incubator maintains optimal temperature, humidity and other conditions such as the CO (CO2) and oxygen content of the atmosphere inside.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://assets.fishersci.com/TFS-Assets/CCG/product-images/F308960~p.eps-650.jpg",
                        "incubator_5"));

        productlist
                .add(new Product(
                        " Incubator",
                        "Royal Oak Engineered Wood Coffee Table",
                        "Incubator is a device used to grow and maintain microbiological cultures or cell cultures. The incubator maintains optimal temperature, humidity and other conditions such as the CO (CO2) and oxygen content of the atmosphere inside.",
                        "10200",
                        "12",
                        "7000",
                        "0",
                        "https://5.imimg.com/data5/EE/PB/MY-19346435/laboratory-incubator-500x500.jpg",
                        "incubator_6"));

        productMap.put("Incubator", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "Laying Nest",
                        "Laying Nest",
                        "Laying Nest.",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://momwithaprep.com/wp-content/uploads/2015/06/momwithaprep-15-chicken-nesting-box-hacks-3.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Laying Nest",
                        "Laying Nest",
                        "Laying Nest",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://www.eggcartonstore.com/v/vspfiles/photos/TECS-NS-16-3.jpg",
                        "chair_2"));

        productlist
                .add(new Product(
                        "Laying Nest",
                        "Laying Nest",
                        "Laying Nest",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://www.eggcartonstore.com/v/vspfiles/photos/TECS-NS-1-2.jpg",
                        "chair_3"));

        productlist
                .add(new Product(
                        "Laying Nest",
                        "Laying Nest",
                        "Laying Nest",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://momwithaprep.com/wp-content/uploads/2015/06/momwithaprep-15-chicken-nesting-box-hacks-3.jpg",
                        "chair_4"));

        productlist
                .add(new Product(
                        "Laying Nest",
                        "Laying Nest",
                        "Laying Nest",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://www.eggcartonstore.com/v/vspfiles/photos/TECS-NS-16-3.jpg",
                        "chair_5"));

        productlist
                .add(new Product(
                        "Laying Nest",
                        "Laying Nest",
                        "Laying Nest",
                        "36500",
                        "20",
                        "1200",
                        "0",
                        "https://www.eggcartonstore.com/v/vspfiles/photos/TECS-NS-1-2.jpg",
                        "chair_6"));


        productMap.put("Laying Nest", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "Coops and Cages",
                        "Coops and Cages",
                        "Coops and Cages",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://jeffreymhartman.com/wp-content/uploads/2018/09/large-folding-run-with-hutch-error-giant-rabbit-garden-buildings-and-coops-cages-the-best-of-extra-indoor-cage-for-sale.jpg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "Coops and Cages",
                        "Coops and Cages",
                        "Coops and Cages",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://www.rexdixon.com/assets/upload/2018/4/the-different-types-of-guinea-pig-cages-coops-cages-coops-and-cages.jpg",
                        "almirah_2"));

        productlist
                .add(new Product(
                        "Coops and Cages",
                        "Coops and Cages",
                        "Coops and Cages",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://www.chicken-cages.com/img/hen-house.jpg",
                        "almirah_3"));

        productlist
                .add(new Product(
                        "Coops and Cages",
                        "Coops and Cages",
                        "Coops and Cages",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://upload.wikimedia.org/wikipedia/commons/d/d1/A-frame_chicken_coop%2C_Portland_OR.JPG",
                        "almirah_4"));

        productlist
                .add(new Product(
                        "Coops and Cages",
                        "Coops and Cages",
                        "Coops and Cages",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "https://images-eu.ssl-images-amazon.com/images/I/51p7I3q3GRL._SX300_QL70_.jpg",
                        "almirah_5"));



        productMap.put("Coops and Cages", productlist);

        productMap.put("Coops and Cages", productlist);

        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllProducts(int productCategory) {

        if (productCategory == 0) {

            getAllElectronics();
        } else {

            getAllFurnitures();

        }

    }

}
