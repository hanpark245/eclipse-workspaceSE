package movie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import theater.TheaterVo;

public class MovieDao {
	private File movieFile;
	public MovieDao() throws Exception {
		init();
	}
	private void init() throws Exception {
		movieFile = new File("movie.ser");
		if (!movieFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(movieFile));
			oos.writeObject(new ArrayList<MovieVo>());
			oos.close();
			System.out.println("--------颇老积己[movie.ser]---------");
		} else {
			System.out.println("--------颇老粮犁[movie.ser]--------");
		}
	}
	private ArrayList<MovieVo> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(movieFile));
		ArrayList<MovieVo> movie = (ArrayList<MovieVo>) ois.readObject();
		ois.close();
		return movie;
	}
	private void writeFile(ArrayList<MovieVo> movieList)  throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(movieFile));
		oos.writeObject(movieList);
		oos.close();
	}
	/*
	 * Create
	 */
	public void create(MovieVo movie) throws Exception {
		ArrayList<MovieVo> movieList = this.readFile();
		movie.setMovieNumber(movieList.size()+1);
		movieList.add(movie);
		this.writeFile(movieList);
	}
	
	/*
	 * Read all
	 */
	public ArrayList<MovieVo> readAll() throws Exception {
		return readFile();
		
	}
	
	/*
	 * Read One
	 */
	public MovieVo readOne(int movieNumber) throws Exception {
		for (int i = 0; i < readFile().size(); i++) {
			MovieVo findMovie = readFile().get(i);
			if (findMovie.getMovieNumber() == movieNumber) {
				return findMovie;
			}
		}		
		return null;
	}
	
	/*
	 * Update
	 */
	public void update(MovieVo updateMovie) throws Exception{
		ArrayList<MovieVo> movieList = this.readFile();
		int count = movieList.size();
		for (int i = 0; i < movieList.size(); i++) {
			if(movieList.get(i).getMovieNumber() == updateMovie.getMovieNumber());
			count=i;
			movieList.set(i, updateMovie);
			break;
		}
		for (int i = 0; i < movieList.size(); i++) {
			movieList.get(i).setMovieNumber(movieList.get(i).getMovieNumber()+1);
			break;
		}
		this.writeFile(movieList);
	}
	
	/*
	 * Delete
	 */
	public void delete(int movieNumber) throws Exception {
		ArrayList<MovieVo> movieList = this.readFile();
		int count=movieList.size();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getMovieNumber() == movieNumber) {
				count=i;
				movieList.remove(i);
				break;
			}
		}
		for (int i = count; i < movieList.size(); i++) {
			movieList.get(i).setMovieNumber(movieList.get(i).getMovieNumber()-1);
		}
		this.writeFile(movieList);
	}

	
}
