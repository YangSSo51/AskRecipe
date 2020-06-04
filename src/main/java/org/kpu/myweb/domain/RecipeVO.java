package org.kpu.myweb.domain;

public class RecipeVO {
	private String id;
	private String title;
	private String url;
	private String ingredients;
	private String recipe;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	@Override
	public String toString() {
		return "RecipeVO [id=" + id + ", title" + title + ", url="+url+", ingredients=" + ingredients +", recipe="+recipe+  "]";
	}
}
