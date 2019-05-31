package net.Ganesh.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page not found or constructed!");
		mv.addObject("errorDescription", "Requested page is not found or page moved!!");
		mv.addObject("title", "404 error page");
		return mv;

	}

	@ExceptionHandler(ItemNotFoundException.class)
	public ModelAndView handleItemNotFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Item not available!");
		// if (exceptionMsg == null)
		mv.addObject("errorDescription", "Requested item is not available!!");
		/*
		 * else mv.addObject("errorDescription", exceptionMsg);
		 */
		mv.addObject("title", "Item unavailable");
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact Admin!");

		mv.addObject("errorDescription", "Error occurred please contact system admin!");

		//mv.addObject("errorDescription", ex.toString());

		// print stack trace

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);

		mv.addObject("errorDescription", sw.toString());

		mv.addObject("title", "Item unavailable");
		return mv;
	}

}
