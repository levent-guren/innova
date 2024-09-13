package tr.com.innova.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDTO> runtimeException(RuntimeException ex) {
		log.error("runtimeExcetion occured");
		log.error(ex);
		ErrorDTO dto = new ErrorDTO(new Date(), "Error occured");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDTO> globalException(Exception ex) {
		ex.printStackTrace();
		ErrorDTO dto = new ErrorDTO(new Date(), "Error occured");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}
}
