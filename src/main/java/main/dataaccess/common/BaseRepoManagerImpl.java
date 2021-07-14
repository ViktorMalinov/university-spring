package main.dataaccess.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;


public abstract class BaseRepoManagerImpl<PK, ENT> implements BaseRepoManager<PK, ENT> {

	
	protected abstract PK getPk(ENT entity);
	protected abstract Class<?> getClazz(); 
	protected static Logger logger = LoggerFactory.getLogger(BaseRepoManagerImpl.class);

	protected abstract CrudRepository<ENT, PK> getDataSource();
	
	
	//@Autowired
	//public CrudRepository<ENT, PK> repo;
	
	
	
	@Override
	public ENT insert(ENT entity) {
		
		ENT result;
		
		result = getDataSource().save(entity);
		
		logger.info("ISERTING  ---> " + entity.toString());

		return result;
		
	}

	@Override
	public ENT select(PK id) {
		ENT entity = null;
		
		entity = getDataSource().findById(id).orElse(entity);

		logger.info("SELECTING ---> ID: " + id.toString() + ", object: " + entity.toString());

		return entity;
	}

	@Override
	public void update(ENT entity) {
		
		getDataSource().save(entity);		
		
		logger.info("UPDATING  --->  object: " + entity.toString());
		
	}

	@Override
	public void delete(PK id) {
		getDataSource().deleteById(id);
		
		logger.info("DELETING  ---> ID: " + id.toString() );
	}

	@Override
	public List<ENT> selectAll() {
		List<ENT> result = new ArrayList<ENT>();
		
		Iterable<ENT> entity = getDataSource().findAll();
		
		entity.forEach(result::add);
		
		return result;
	}
	
	
	//---------------------------------------------------------------
	
	/*
	public void load() {
		ObjectMapper mapper = new ObjectMapper();
		File dataFile = new File(getPath());
		
		if (!dataFile.exists()) return; 
		
		try {
		
			List<ENT> listENT =  mapper.readValue(dataFile, mapper.getTypeFactory().constructCollectionType(List.class, getClazz()));

			getDataSource().clear();
			
			listENT.stream().forEach(e -> { getDataSource().put(getPk(e), e); } );
			
		
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	public void persist(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(String.valueOf(getPath())), getDataSource().values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

}
