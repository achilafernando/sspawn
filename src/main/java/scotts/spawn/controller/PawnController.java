package scotts.spawn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import scotts.spawn.entitiy.OnlinePayments;
import scotts.spawn.entitiy.Pawn;
import scotts.spawn.service.OnlinePaymentService;
import scotts.spawn.service.PawnService;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(PawnController.BASE_URL)
public class PawnController {
    public static final String BASE_URL = "/api/v1/pawn";

    private final PawnService pawnService;
    private final OnlinePaymentService onlinePaymentService;

    public PawnController(PawnService pawnService, OnlinePaymentService onlinePaymentService) {
        this.pawnService = pawnService;
        this.onlinePaymentService = onlinePaymentService;
    }

    @GetMapping
    List<Pawn> getPawnList(){
        return pawnService.findAllPawn();
    }

    @GetMapping("/{id}")
    public Pawn getPawnById(@PathVariable Long id){
        return pawnService.findPawnById(id);
    }

    @GetMapping("/filter")
    List<Pawn> getPawnByIDNO(@RequestParam("nic") String nic,@RequestParam("status") String status){

        int pawnstatus;
        pawnstatus=Integer.parseInt(status);
        return pawnService.findPawnByIDNO(nic,pawnstatus);
    }

    @PutMapping("/update")
    public HttpStatus updatePaid(@RequestParam("mobile") String mobile,@RequestParam("bankref") String bankref, @RequestBody List<PaidRequest>  paidRequest){
//    public HttpStatus updatePaid(@RequestBody List<PaidRequest>  paidRequest ){
//        List<PaidRequest> langList = new ArrayList(Arrays.asList(paidrequest));

//        langList.forEach((temp) -> {
//            System.out.println(temp);
//        } );


        try {
            for (int i = 0; i < paidRequest.size(); i++) {
                System.out.println(paidRequest.get(i));
                Pawn ExsistingData = pawnService.findPawnById(Long.parseLong(paidRequest.get(i).getPawnid().toString()));

                if (ExsistingData!=null){
                    ExsistingData.setOnline_paid(paidRequest.get(i).getPaid_amount());
                    Pawn updatedPawn = pawnService.savePawn(ExsistingData);

                    OnlinePayments onlinePayments = new OnlinePayments();
                    onlinePayments.setPaidAmount(paidRequest.get(i).getPaid_amount());
                    onlinePayments.setPawnId(paidRequest.get(i).getPawnid());
                    onlinePayments.setBankref(bankref);
                    onlinePayments.setMobile(mobile);
                    onlinePaymentService.SavePaymnet(onlinePayments);


                }
            }
            return HttpStatus.OK;
        }
        catch (Exception e) {
            return HttpStatus.NOT_ACCEPTABLE;
        }

//        return   HttpStatus.NOT_ACCEPTABLE;
    }




//    @GetMapping("/{id}")
//    public Customer getCustomerById(@PathVariable Long id) {
//        return customerService.findCustomerById(id);
//    }

}
