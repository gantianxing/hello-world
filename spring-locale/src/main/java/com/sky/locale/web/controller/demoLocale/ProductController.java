package com.sky.locale.web.controller.demoLocale;

import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class ProductController {
	
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/add-product")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "/demoLocale/ProductForm";
	}

	@RequestMapping(value="/save-product")
	public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult,HttpServletRequest request,
			Model model,Locale locale) {
        ProductValidator productValidator = new ProductValidator();
        productValidator.validate(product, bindingResult);

		RequestContext requestContext = new RequestContext(request);
		String unit = requestContext.getMessage("unit.pos");
		model.addAttribute("unit", unit);

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.debug("Code:" + fieldError.getCode() + ", field:"
					+ fieldError.getField());
			System.out.println("Code:" + fieldError.getCode() + ", field:"
					+ fieldError.getField());
			return "/demoLocale/ProductForm";
        }
		
		// save product here

		model.addAttribute("product", product);
		return "/demoLocale/ProductDetails";
	}

	@RequestMapping(value = "/changelanguage", method = RequestMethod.POST)
	public void changeLanguage(@RequestParam String new_lang,HttpServletRequest request, HttpServletResponse response)
	{
		String msg = "";

		try
		{
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			if (localeResolver == null) {
				throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
			}

			LocaleEditor localeEditor = new LocaleEditor();
			localeEditor.setAsText(new_lang);
			localeResolver.setLocale(request, response, (Locale)localeEditor.getValue());

			msg = "Change Language Success!";
		}
		catch(Exception ex)
		{
			msg = "error";
			ex.printStackTrace();
		}

		response.setCharacterEncoding(CharEncoding.UTF_8);

		try {
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
