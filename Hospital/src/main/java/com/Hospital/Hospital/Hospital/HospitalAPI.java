import com.Hospital.Hospital.Hospital.Hospital;
import com.Hospital.Hospital.Hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalAPI {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalAPI(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Hospital hospital){
        return ResponseEntity.ok(this.hospitalService.salvar(hospital));
    }

    @PostMapping("/gerar-alas")
    public ResponseEntity gerarAlas(@RequestBody Hospital hospital) {
        return ResponseEntity.ok(this.hospitalService.gerarAlas(hospital));
    }

    @PostMapping("/internar-paciente")
    public ResponseEntity internarPaciente(@RequestParam Integer pacienteId, @RequestParam String especialidade) {
        return ResponseEntity.ok(this.hospitalService.internarPaciente(pacienteId, especialidade));
    }

    @PostMapping("/dar-alta")
    public ResponseEntity darAlta(@RequestParam Long pacienteId) {
        return ResponseEntity.ok(this.hospitalService.darAlta(pacienteId));
    }
}
