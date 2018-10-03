package com.stackroute.juggler.movieschedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Seats;
import com.stackroute.juggler.movieschedule.service.MovieScheduleService;

@Component
public class DataLoader implements ApplicationRunner {

	private MovieScheduleService movieScheduleService;

	// Constructor
	@Autowired
	public DataLoader(MovieScheduleService movieScheduleService) {
		this.movieScheduleService = movieScheduleService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		for (int i = 0; i < 10; i++) {
			// list1[i]=new ArrayList<Integer>();
			list1.add(i);
			list2.add(i);
		}
		String[] typesOfSeats = { "Platnium", "Gold", "Silver" };
		int[] noOfSeats = new int[] { 10, 20, 30 };
		int[] weekendsprice = new int[] { 100, 20, 30 };
		int[] weekdayprice = new int[] { 10, 20, 30 };
		Seats local = new Seats(10, 10, list1, list2);
		MovieSchedule local1 = new MovieSchedule("t25", "XimTakies", "theatre8@gmail.com",
				"1-6-1,Sriram Nagar ColonyMain Road, ECIL,Mumbai-500045", "Mumbai", "Radhika123", "100", local,
				typesOfSeats, noOfSeats, "m3", "Gold",
				"http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg",
				"Akshay Kumar", "Mouny Roy", "Reema Kagti", "Drama",
				"A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.",
				"2D", "Hindi", "02:33:00", "26/09/2018", 2, "09:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local1);
		MovieSchedule local2 = new MovieSchedule("t26", "Meghana70mm", "theatre8@gmail.com",
				"1-6-1,Sriram Nagar ColonyMain Road, ECIL,Mumbai-500045", "Mumbai", "Radhika123", "100", local,
				typesOfSeats, noOfSeats, "m3", "Sui Dhaaga - Made In India",
				"http://www.gstatic.com/tv/thumb/movieposters/15844343/p15844343_p_v8_aa.jpg", "Varun Dhawan",
				"Anushka Sharma", "Sharat Katariya", "Drama",
				"The movie depicts the unbelievable transition of an unemployed married man to a self-employed business owner. In Sui Dhaaga, Varun will be seen essaying the role of a tailor.",
				"2D", "Hindi", "02:33:00", "27/09/2018", 2, "09:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local2);
		MovieSchedule local3 = new MovieSchedule("t27", "PVRMumbai", "theatre8@gmail.com",
				"1-6-1,Sriram Nagar ColonyMain Road, ECIL,Mumbai-500045", "Mumbai", "Radhika123", "100", local,
				typesOfSeats, noOfSeats, "m3", "Loveyatri",
				"https://www.bollywoodlife.com/wp-content/uploads/2018/02/DV7pQD1X4AEfPxv.jpg", "Aayush Sharma",
				"Warina Hussain", "Abhiraj Minawala", "Romance",
				"Loveyatri is a 2018 Bollywood musical romance-drama, helmed by debutante Abhiraj Minawala. The movie stars Salman Khan's brother-in-law  Aayush Sharma and debutante Warina Hussain in lead roles.The movie is produced by Salman Khan and Salma Khan under the banner Salman Khan Films Pvt.Ltd and is distributed by Yash Raj Films. The movie has its music by Tanishk Bagchi, JAM8 and DJ Chetas-Lijo George. Jishnu Bhattacharjee has wielded the camera for Loveyatri. ",
				"2D", "Hindi", "02:33:00", "05/10/2018", 3, "09:00,17:00,22:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local3);
		MovieSchedule local4 = new MovieSchedule("t28", "INOXMumbai", "theatre8@gmail.com",
				"1-6-1,Sriram Nagar ColonyMain Road, ECIL,Mumbai-500045", "Mumbai", "Radhika123", "100", local,
				typesOfSeats, noOfSeats, "m3", "Andhadhun", "https://static.toiimg.com/photo/64664105.cms",
				"Akshay Kumar", "Radhika Apte", "Sriram Raghavan", "Thriller",
				"A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.",
				"2D", "Hindi", "02:33:00", "05/10/2018", 3, "09:00,17:00,22:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local4);
		MovieSchedule local5 = new MovieSchedule("t29", "Miraj4K", "theatre6@gmail.com",
				"Arcade,Opposite Athidhi Restaurant, Mumbai-500234", "Mumbai", "Arcade123", "100", local, typesOfSeats,
				noOfSeats, "m1", "Nota", "https://upload.wikimedia.org/wikipedia/en/7/72/Nota_film_poster.jpg",
				"Vijay Devarakonda", "Mehreen Kaur Pirzada", "Anand Shankar", "Action",
				"NOTA is a Tamil movie starring Vijay deverakonda and Mehreen Kaur Pirzada in prominent roles. It is a drama directed by Anand Shankar with Sam C. S. as the musician, forming part of the crew.",
				"2D", "Telugu", "02:23:22", "27/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local5);
		MovieSchedule local6 = new MovieSchedule("t30", "CineTown3D", "theatre21@gmail.com",
				"Shaan,BM Road, Ramanagaram, Mumbai-562159", "Mumbai", "Shaan123", "100", local, typesOfSeats,
				noOfSeats, "m21", "Vilan",
				"https://in.bmscdn.com/iedb/movies/images/website/poster/large/the-villain-et00078678-27-06-2018-04-58-06.jpg",
				"ShivaRajkumar,Sudeep", "Amy Jackson", "Prem", "Action",
				"The Villain is a Kannada movie stars Shiva Rajkumar and Kiccha Sudeep in prominent roles. It is an action drama directed by Prem. ",
				"3D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local6);
		MovieSchedule local7 = new MovieSchedule("t31", "CineTown2D", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Mumbai-500234", "Mumbai", "Cine Town123", "100",
				local, typesOfSeats, noOfSeats, "m4", "96",
				"https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg",
				"Vijay Sethupatti", "Trisha Krishnan", "Prem Kumar", "Drama",
				"A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.",
				"2D", "Tamil", "02:30:00", "28/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local7);
		MovieSchedule local8 = new MovieSchedule("t32", "CineSquare", "theatre6@gmail.com",
				"99, Shantinagar, Near IBP Petrol Pump,Uppal,East,Mumbai-500060", "Mumbai", "Cinesquare123", "100",
				local, typesOfSeats, noOfSeats, "m1", "Bad Boys",
				"https://timesofindia.indiatimes.com/thumb/65715755.cms?width=219&height=317&imgsize=77504",
				"Sanu Khan", "Muzzamal Hussain", "Saiful Islam", "Drama",
				"Bad Boys is an Assamese movie starring Sanu Khan, Muzammel Hussain and Parbin Rashid in prominent roles. It is a drama directed by Saiful Islam, forming part of the crew.",
				"2D", "Assamese", "03:16:00", "27/09/2018", 2, "10:00,13:30", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local8);
		MovieSchedule local9 = new MovieSchedule("t21", "Arcade", "theatre6@gmail.com",
				"Arcade,Opposite Athidhi Restaurant, Kengeri, Chennai-500234", "Chennai", "Arcade123", "100", local,
				typesOfSeats, noOfSeats, "m1", "Nota",
				"https://upload.wikimedia.org/wikipedia/en/7/72/Nota_film_poster.jpg", "Vijay Devarakonda",
				"Mehreen Kaur Pirzada", "Anand Shankar", "Action",
				"NOTA is a Tamil movie starring Vijay deverakonda and Mehreen Kaur Pirzada in prominent roles. It is a drama directed by Anand Shankar with Sam C. S. as the musician, forming part of the crew.",
				"2D", "Telugu", "02:23:22", "27/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local9);
		MovieSchedule local10 = new MovieSchedule("t22", "ChennaiTakies", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m21", "Vilan",
				"https://in.bmscdn.com/iedb/movies/images/website/poster/large/the-villain-et00078678-27-06-2018-04-58-06.jpg",
				"ShivaRajkumar,Sudeep", "Amy Jackson", "Prem", "Action",
				"The Villain is a Kannada movie stars Shiva Rajkumar and Kiccha Sudeep in prominent roles. It is an action drama directed by Prem. ",
				"3D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local10);
		MovieSchedule local11 = new MovieSchedule("t23", "Thaliva", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m1", "Bad Boys",
				"https://timesofindia.indiatimes.com/thumb/65715755.cms?width=219&height=317&imgsize=77504",
				"Sanu Khan", "Muzzamal Hussain", "Saiful Islam", "Drama",
				"Bad Boys is an Assamese movie starring Sanu Khan, Muzammel Hussain and Parbin Rashid in prominent roles. It is a drama directed by Saiful Islam, forming part of the crew.",
				"2D", "Assamese", "03:16:00", "27/09/2018", 2, "10:00,13:30", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local11);
		MovieSchedule local12 = new MovieSchedule("t24", "Thala", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m3", "Gold",
				"http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg",
				"Akshay Kumar", "Mouny Roy", "Reema Kagti", "Drama",
				"A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.",
				"2D", "Hindi", "02:33:00", "26/09/2018", 2, "09:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local12);
		MovieSchedule local13 = new MovieSchedule("t17", "Thalapathi", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m4", "96",
				"https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg",
				"Vijay Sethupatti", "Trisha Krishnan", "Prem Kumar", "Drama",
				"A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.",
				"2D", "Tamil", "02:30:00", "28/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local13);
		MovieSchedule local14 = new MovieSchedule("t18", "Mercuery", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m4", "Chekka Chivantha Vaanam",
				"https://www.studioflicks.com/wp-content/uploads/2018/08/Chekka-Chivantha-Vaanam-Movie-Posters.jpg",
				"Simbu, Vijay Sethupathi, Aravindswami,Arun Vijay", "Jyothika,Aditi Rao", "Maniratnam", "Drama",
				"Chekka Chivantha Vaanam is a Tamil action romance movie directed by Maniratnam. The movie star cast includes Simbu, Vijay Sethupathi, Aravindswami, Jyotika, Arun Vijay, Aishwarya Rajesh and Aditi Rao in the lead roles.",
				"2D", "Tamil", "02:30:00", "28/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local14);
		MovieSchedule local15 = new MovieSchedule("t19", "Venus", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m4", "Pariyerum Perumal",
				"https://moviegalleri.net/wp-content/uploads/2018/02/Pariyerum-Perumal-First-Look-Posters-HD.jpg",
				"Kathir", "Anandi", "Mari Selvaraj", "Drama",
				"Pariyerum Perumal is a Tamil drama movie, directed by Mari Selvaraj. The cast of Pariyerum Perumal includes Kathir,Anandi.",
				"2D", "Tamil", "02:30:00", "28/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local15);
		MovieSchedule local16 = new MovieSchedule("t20", "Thamizah", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Chennai-500234", "Chennai", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m22", "Natasaarvabhowma",
				"https://i.ytimg.com/vi/d4XDmowEhDE/hqdefault.jpg", "Punith Rajkumar", "Rachita Ram", "Pavan Wodeyar",
				"Action",
				"Natasaarvabhowma is a Kannada movie starring Puneeth Rajkumar in a prominent It is a role. It is a drama written and directed by Pawan Wodeyar.  ",
				"3D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local16);
		MovieSchedule local17 = new MovieSchedule("t17", "MarsInox", "theatre7@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345", "Bangalore", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m2", "Mission Impossible- Fallout",
				"https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg",
				"Tom Cruise", "Rebacca Ferguson", "Cristopher McQuarie", "Action",
				"In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.",
				"3D", "English", "02:28:00", "27/09/2018", 3, "10:00,13:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local17);
		MovieSchedule local18 = new MovieSchedule("t18", "VishnuTakies", "theatre8@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345", "Bangalore", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m3", "Gold",
				"http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg",
				"Akshay Kumar", "Mouny Roy", "Reema Kagti", "Drama",
				"A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.",
				"2D", "Hindi", "02:33:00", "26/09/2018", 2, "09:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local18);
		MovieSchedule local19 = new MovieSchedule("t19", "AmarTakies", "theatre9@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345", "Bangalore", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m4", "96",
				"https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg",
				"Vijay Sethupatti", "Trisha Krishnan", "Prem Kumar", "Drama",
				"A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.",
				"2D", "Tamil", "02:30:00", "28/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local19);
		MovieSchedule local20 = new MovieSchedule("t20", "TejaTakies", "theatre10@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345", "Bangalore", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m5", "Nannu Dochukunduvate",
				"https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885",
				"Suresh Babu", "Nabha Natesha", "R S Naidu", "Romance",
				"Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.",
				"2D", "Telugu", "02:29:00", "27/09/2018", 3, "11:00,14:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local20);
		MovieSchedule local21 = new MovieSchedule("t21", "Pkr", "theatre22@gmail.com",
				"PVR,BM Road, Ramanagaram, Banglore-562159", "Bangalore", "Pvr123", "100", local, typesOfSeats,
				noOfSeats, "m22", "Natasaarvabhowma", "https://i.ytimg.com/vi/d4XDmowEhDE/hqdefault.jpg",
				"Punith Rajkumar", "Rachita Ram", "Pavan Wodeyar", "Action",
				"Natasaarvabhowma is a Kannada movie starring Puneeth Rajkumar in a prominent It is a role. It is a drama written and directed by Pawan Wodeyar.  ",
				"3D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local21);
		MovieSchedule local22 = new MovieSchedule("t22", "Shaan", "theatre21@gmail.com",
				"Shaan,BM Road, Ramanagaram, Banglore-562159", "Bangalore", "Shaan123", "100", local, typesOfSeats,
				noOfSeats, "m21", "Vilan",
				"https://in.bmscdn.com/iedb/movies/images/website/poster/large/the-villain-et00078678-27-06-2018-04-58-06.jpg",
				"ShivaRajkumar,Sudeep", "Amy Jackson", "Prem", "Action",
				"The Villain is a Kannada movie stars Shiva Rajkumar and Kiccha Sudeep in prominent roles. It is an action drama directed by Prem. ",
				"3D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local22);
		MovieSchedule local23 = new MovieSchedule("t20", "Arcade", "theatre20@gmail.com",
				"Arcade,Opposite Athidhi Restaurant, Kengeri, Banglore-500234", "Bangalore", "Arcade123", "100", local,
				typesOfSeats, noOfSeats, "m20", "KGF",
				"https://in.bmscdn.com/iedb/movies/images/website/poster/large/kgf-et00042769-04-10-2016-03-44-43.jpg",
				"Yash", "Srinidhi", "Prem Kumar", "Action",
				"A period drama narrates the 17000-year-old history of oppressed waging wars against their oppressors. Set in the early 80s, KGF - the first chapter centers the protagonist who leads a battle against oppressors.",
				"2D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local23);
		MovieSchedule local24 = new MovieSchedule("t1", "Arcade", "theatre6@gmail.com",
				"Arcade,Opposite Athidhi Restaurant, Kengeri, Hyderabad-500234", "Hyderabad", "Arcade123", "100", local,
				typesOfSeats, noOfSeats, "m1", "Nota",
				"https://upload.wikimedia.org/wikipedia/en/7/72/Nota_film_poster.jpg", "Vijay Devarakonda",
				"Mehreen Kaur Pirzada", "Anand Shankar", "Action",
				"NOTA is a Tamil movie starring Vijay deverakonda and Mehreen Kaur Pirzada in prominent roles. It is a drama directed by Anand Shankar with Sam C. S. as the musician, forming part of the crew.",
				"2D", "Telugu", "02:23:22", "27/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local24);
		MovieSchedule local25 = new MovieSchedule("t2", "Sandhya70MM", "theatre7@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345", "Bangalore", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m2", "Nannu Dochukunduvate",
				"https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885",
				"Suresh Babu", "Nabha Natesha", "R S Naidu", "Romance",
				"Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.",
				"2D", "Telugu", "02:29:00", "27/09/2018", 3, "11:00,14:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local25);
		MovieSchedule local26 = new MovieSchedule("t3", "Pkr", "theatre22@gmail.com",
				"PVR,BM Road, Ramanagaram, Banglore-562159", "Bangalore", "Pvr123", "100", local, typesOfSeats,
				noOfSeats, "m22", "Natasaarvabhowma", "https://i.ytimg.com/vi/d4XDmowEhDE/hqdefault.jpg",
				"Punith Rajkumar", "Rachita Ram", "Pavan Wodeyar", "Action",
				"Natasaarvabhowma is a Kannada movie starring Puneeth Rajkumar in a prominent It is a role. It is a drama written and directed by Pawan Wodeyar.  ",
				"3D", "Kannada", "02:30:00", "26/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local26);
		MovieSchedule local27 = new MovieSchedule("t1", "GPR", "theatre7@gmail.com",
				"3rd Floor,More Mega Mart Complex Kukatpally,Hyderabad-500092", "Hyderabad", "GPR123", "100", local,
				typesOfSeats, noOfSeats, "m2", "Mission Impossible- Fallout",
				"https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg",
				"Tom Cruise", "Rebacca Ferguson", "Cristopher McQuarie", "Action",
				"In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.",
				"3D", "English", "02:28:00", "27/09/2018", 3, "10:00,13:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local27);
		MovieSchedule local28 = new MovieSchedule("t5", "XimTakies", "theatre8@gmail.com",
				"1-6-1,Sriram Nagar ColonyMain Road, ECIL,Hyderabad-500045", "Hyderabad", "Radhika123", "100", local,
				typesOfSeats, noOfSeats, "m3", "Gold",
				"http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg",
				"Akshay Kumar", "Mouny Roy", "Reema Kagti", "Drama",
				"A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.",
				"2D", "Hindi", "02:33:00", "26/09/2018", 2, "09:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local28);
		MovieSchedule local29 = new MovieSchedule("t6", "Sandhya70MM", "theatre9@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Hyderabad-500345", "Hyderabad", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m2", "Nannu Dochukunduvate",
				"https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885",
				"Suresh Babu", "Nabha Natesha", "R S Naidu", "Romance",
				"Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.",
				"2D", "Telugu", "02:29:00", "27/09/2018", 3, "11:00,14:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local29);
		MovieSchedule local30 = new MovieSchedule("t7", "CineTown", "theatre9@gmail.com",
				"Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Hyderabad-500234", "Hyderabad", "Cine Town123",
				"100", local, typesOfSeats, noOfSeats, "m4", "96",
				"https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg",
				"Vijay Sethupatti", "Trisha Krishnan", "Prem Kumar", "Drama",
				"A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.",
				"2D", "Tamil", "02:30:00", "28/09/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local30);
		MovieSchedule local31 = new MovieSchedule("t17", "MarsInox", "theatre7@gmail.com",
				"8-1-364/A, Brindhavan Colony,Tolichowki, West, Hyderabad-500345", "Hyderabad", "Galaxy123", "100",
				local, typesOfSeats, noOfSeats, "m2", "Mission Impossible- Fallout",
				"https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg",
				"Tom Cruise", "Rebacca Ferguson", "Cristopher McQuarie", "Action",
				"In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.",
				"3D", "English", "02:28:00", "27/09/2018", 3, "10:00,13:00,17:00", weekendsprice, weekdayprice);
		movieScheduleService.addMovieSchedule(local31);

	}
}

