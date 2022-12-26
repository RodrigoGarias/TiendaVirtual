package com.danaide.tiendavirtual.controller;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danaide.tiendavirtual.dto.ProductDTO;
import com.danaide.tiendavirtual.enums.ProductCategory;
import com.danaide.tiendavirtual.model.Product;
import com.danaide.tiendavirtual.service.ProductService;

@RestController
@RequestMapping( "/api/priv/product" )
public class ProductController extends BaseRestController {

	private @Autowired ProductService productService;
	
	public ProductController() {
		super();
	}
	
	
	/**
	 * Endpoind that returns a list of productos. If any paramenter is send , it returns all de productos of the shop. If page an size is send , it will be a pageable list.
	 * @Optional @param page
	 * @Optional @param size
	 * @Optional @param category
	 * @return
	 */
	@GetMapping("list")
	public Map<String,Object> getProductsList( @RequestParam (name = "page" , required = false ) Integer page , @RequestParam ( name = "size" , required = false  ) Integer size , @RequestParam ( name = "category" , required = false  ) ProductCategory category ){
		return super.executeService( () ->{
			return this.productService.getList( page , size , category )
					.stream()
					.map( item -> super.modelMapper.map(item, ProductDTO.class) )
					.collect( Collectors.toSet() );
		});
	}

	
	
	/**
	 * Endpoint that return all the categorys of the Shop
	 * @return
	 */
	@GetMapping("/category/list")
	public Map< String , Object > getProductCategoryList(){
		return super.executeService( ()-> {
			return this.productService.getProductsCategoryList();
		});
	}
	
	
	
	@PostMapping()
	public Map< String, Object > addProduct( @RequestBody ProductDTO productDTO ) {
		return super.executeVoidService( ()->{
			this.productService.addProduct( productDTO  );
		});
	}
	
	
	
}
