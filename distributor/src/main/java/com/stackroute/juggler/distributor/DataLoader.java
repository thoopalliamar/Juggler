package com.stackroute.juggler.distributor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.distributor.domain.Movie;
import com.stackroute.juggler.distributor.repositary.MovieRepositary;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private MovieRepositary movieRepositary;

	public DataLoader(MovieRepositary movieRepository) {
		this.movieRepositary = movieRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		movieRepositary.save(new Movie("1", "The Nun",
				"http://www.gstatic.com/tv/thumb/movieposters/13794422/p13794422_p_v8_af.jpg", "Demián Bichir",
				"Taissa Farmiga", "Corin Hardy", "Horror",
				"When a young nun at a cloistered abbey in Romania takes her own life, a priest with a haunted past and a novitiate on the threshold of her final vows are sent by the Vatican to investigate. Together, they uncover the order's unholy secret. Risking not only their lives but their faith and their very souls, they confront a malevolent force in the form of a demonic nun",
				"2D", "English", "02:13:42", "25/09/2018"));
		movieRepositary.save(new Movie("2", "Halloween",
				"https://hdqwalls.com/download/halloween-2018-movie-5k-z6-640x960.jpg", "Jamie Lee Curtis",
				"Judy Greer", "David Gordon Green", "Horror",
				"Laurie Strode comes to her final confrontation with Michael Myers, the masked figure who has haunted her since she narrowly escaped his killing spree on Halloween night four decades ago.",
				"2D", "English", "02:13:42", "25/09/2018"));
		movieRepositary.save(new Movie("3", "Kurukshethram",
				"https://www.filmibeat.com/img/220x100x275/popcorn/movie_posters/kurukshetram-20170626124011-16127.jpg",
				"Arjun", "Sruthi Hariharan", "Arun  Vaidhyanathan", "Drama",
				"Ranjith Kalidoss(Arjun) is the deputy superintendent of police who is a master in solving intense crime cases. One fine day, he along with his team (Prasanna and Varalakshmi) take up a high-profile case which involves a series of murders. After each murder, the culprit throws a challenge to the police by leaving clues to his next crime. Who is this mysterious murderer? What is his intention behind the series of murders?",
				"2D", "Telugu", "02:30:56", "23/09/2018"));
		movieRepositary.save(new Movie("4", "Sailaja Reddy Alludu",
				"https://timesofindia.indiatimes.com/thumb/65580376.cms?width=219&height=317&imgsize=86147",
				"Naga Chaithanya", "Anu Emmanuel", "Maruthi Dasari", "Action",
				"Chaitanya and Anu are neighbours who fall for each other. However their path towards marriage is far from easy. A haughty would-be mother-in-law complicates the proceedings. The couple put up a united front to clear their roadblocks.",
				"2D", "Telugu", "02:30:42", "27/09/2018"));
		movieRepositary.save(new Movie("5", "U Turn",
				"https://www.filmibeat.com/img/220x100x275/popcorn/movie_posters/u-turn-20180814113845-17347.jpg",
				"Aadhi Pinisetty", "Samantha Akkineni", "Pawan Kumar", "Thriller",
				"When a flyover in the city becomes the hotbed of accidents, a young reporter decides to investigate the issue. Her quest for an answer would lead her into a web of intrigue, murder and mystery.",
				"2D", "Telugu", "02:23:42", "25/09/2018"));
		movieRepositary.save(new Movie("6", "Saamy Square",
				"http://wishesh.com/images/movie-events/Saamy-Square-In01.jpg", "Vikram", "Keerthy Suresh", "Hari",
				"Action",
				"The movie tells the story of an honest cop Aarusamy (Vikram), who fights against a ruthless politician Perumal Pichai (Kota Srinivasa Rao).",
				"2D", "Tamil", "02:23:22", "26/09/2018"));
		movieRepositary.save(new Movie("7", "Nota",
				"https://in.bmscdn.com/iedb/movies/images/website/poster/large/nota-et00083360-06-09-2018-04-40-17.jpg",
				"Vijay Devarakonda", "Mehreen Kaur Pirzada", "Anand Shankar", "Action",
				"NOTA is a Tamil movie starring Vijay deverakonda and Mehreen Kaur Pirzada in prominent roles. It is a drama directed by Anand Shankar with Sam C. S. as the musician, forming part of the crew. ",
				"2D", "Tamil", "02:23:22", "27/09/2018"));
		movieRepositary.save(new Movie("8", "Seemaraja",
				"http://www.q-tickets.com/movie_images/SEEMA_RAJA_(TAMIL)_thumb.jpg", "Sivakarthikeyan",
				"Samantha Ruth Prabhu", "Ponram", "Comedy",
				"Sivakarthikeyan is the prince of the town who travels in helicopters and has money to spare and Samantha, a girl from town, is not aware of Raja's (Siva) existence and his background...",
				"2D", "Tamil", "02:23:22", "25/09/2018"));
		movieRepositary.save(new Movie("9", "Manto",
				"https://upload.wikimedia.org/wikipedia/en/d/dc/Manto_film_poster_2017.jpg", "Nawazuddin Siddiqui",
				"Rasika Dugal", "Nandita Das", "Drama",
				"The biographical drama chronicles the life and times of celebrated and controversial Urdu short story writer Saadat Hasan Manto.",
				"2D", "Hindi", "02:23:22", "26/09/2018"));
		movieRepositary.save(new Movie("10", "Batti Gul Meter Chalu",
				"https://in.bmscdn.com/iedb/movies/images/website/poster/large/batti-gul-meter-chalu-et00065101-13-11-2017-12-01-57.jpg",
				"Shahid Kapoor", "Shraddha Kapoor", "Shree Narayan Singh", "Drama",
				"The film tells the story of inflated electricity bills in rural India and stars Shahid Kapoor, Shraddha Kapoor, Divyendu Sharma, and Yami Gautam.",
				"2D", "Hindi", "02:23:22", "25/09/2018"));

	}

}
