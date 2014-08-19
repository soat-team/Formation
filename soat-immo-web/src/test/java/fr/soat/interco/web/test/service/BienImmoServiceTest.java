package fr.soat.interco.web.test.service;

import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.TypeImmo;
import fr.soat.interco.web.service.BienImmoService;
import fr.soat.interco.web.test.ParentTests;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

/**
 * BienImmoBilier Service Tests.
 */
public class BienImmoServiceTest extends ParentTests {

    private static final int NB_BIEN_IMMO = 10;
    private final Random random = new Random();

    private static final String ADRESS_IMMO = "ADRESSE_";
    private static final String SURFACE = "SURFACE_";
    private final LocalDate today = LocalDate.now();
    private final static Double LOYER_CST = 350.0;
    private final static Double CHARGE_CST = 50.0;



    @Autowired
    private BienImmoService bienImmoService;

    /**
     * Creates a new Bien immo
     * @return
     */
    private BienImmobilier createBienImmo(String adresse, short etage, short nbPieces, LocalDate disponibilite,
                                          double charges, double loyer, String surface){
        BienImmobilier bienImmobilier = new BienImmobilier();
        bienImmobilier.setAdresse(adresse);
        bienImmobilier.setActive(true);
        bienImmobilier.setAscenseur(Boolean.TRUE);
        bienImmobilier.setEtage(etage);
        bienImmobilier.setNbPieces(nbPieces);
        bienImmobilier.setDateDisponibilite(disponibilite);
        bienImmobilier.setCharges(charges);
        bienImmobilier.setLoyer(loyer);
        bienImmobilier.setPublishedSeLoger(false);
        bienImmobilier.setPublished(false);
        return bienImmobilier;
    }


    @Before
    public void setupData(){
        Assertions.assertThat(bienImmoService).isNotNull();
        for(int i = 0; i < NB_BIEN_IMMO; i++){
            short etage = (short)random.nextInt(NB_BIEN_IMMO);
            short nbPieces = (short)random.nextInt(NB_BIEN_IMMO);
            BienImmobilier bienImmo = createBienImmo(ADRESS_IMMO + i,
                    etage, nbPieces, today, nbPieces * CHARGE_CST,
                    nbPieces * LOYER_CST, SURFACE);
            bienImmo.setType(TypeImmo.APPART);
            bienImmoService.saveBienImmo(bienImmo);
        }

        Iterable<BienImmobilier> allBiensImmo = bienImmoService.findAllBienImmo();
        Assertions.assertThat(allBiensImmo).isNotEmpty();
    }


    @Test
    public void testAllServiceMethodsForBienImmo(){
        int randomId = random.nextInt(NB_BIEN_IMMO);
        List<BienImmobilier> bienImmobiliers = bienImmoService.findBienImmoByAdresse(ADRESS_IMMO);
        Assertions.assertThat(bienImmobiliers).isNotEmpty();

        short etage = (short)random.nextInt(NB_BIEN_IMMO);
        short nbPieces = (short)random.nextInt(NB_BIEN_IMMO);
        BienImmobilier bienImmo = createBienImmo(ADRESS_IMMO + randomId,
                etage, nbPieces, today, nbPieces * CHARGE_CST,
                nbPieces * LOYER_CST, SURFACE);
        bienImmo.setType(TypeImmo.MAISON);
        BienImmobilier bienImmobilier = bienImmoService.saveBienImmo(bienImmo);
        Assertions.assertThat(bienImmobilier).isNotNull();
        Assertions.assertThat(bienImmobilier).isEqualTo(bienImmo);

        //test findBienImmoById
        bienImmobilier = bienImmoService
                .findBienImmoById(bienImmobilier.getIdBien());
        Assertions.assertThat(bienImmobilier).isNotNull();
        Assertions.assertThat(bienImmobilier.getIdBien()).isNotNull();

        //test findAllBienImmo
        Iterable<BienImmobilier> allBienImmo = bienImmoService.findAllBienImmo();
        Assertions.assertThat(allBienImmo).isNotEmpty();
        Assertions.assertThat(allBienImmo).hasSize(NB_BIEN_IMMO + 1);


        //test findImmoByType
        List<BienImmobilier> immoByGarage = bienImmoService.findImmoByType(TypeImmo.GARAGE);
        Assertions.assertThat(immoByGarage).isEmpty();
        List<BienImmobilier> immoByMaison = bienImmoService.findImmoByType(TypeImmo.MAISON);
        Assertions.assertThat(immoByMaison).isNotEmpty();
        Assertions.assertThat(immoByMaison).hasSize(1);
        List<BienImmobilier> immoByType = bienImmoService.findImmoByType(TypeImmo.APPART);
        Assertions.assertThat(immoByType).isNotEmpty();
        Assertions.assertThat(immoByType).hasSize(NB_BIEN_IMMO);

        //test delete bienImmo
        Integer idbien_immobiler = bienImmobilier.getIdBien();
        bienImmoService.deleteBienImmo(bienImmobilier);
        BienImmobilier bienImmoById = bienImmoService.findBienImmoById(idbien_immobiler);
        Assertions.assertThat(bienImmoById).isNull();
    }


    @After
    public void dropData(){
        Iterable<BienImmobilier> allBienImmo = bienImmoService.findAllBienImmo();
        for(BienImmobilier bi : allBienImmo){
            bienImmoService.deleteBienImmo(bi);
        }

        Iterable<BienImmobilier> allBienImmo1 = bienImmoService.findAllBienImmo();
        Assertions.assertThat(allBienImmo1).isEmpty();
    }

}
