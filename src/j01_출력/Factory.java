package j01_출력;

class Factory {

	private String factoryName;
	private static Factory instance = null;

	private Factory() {
		
	}
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
}


