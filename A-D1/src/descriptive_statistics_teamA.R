
###########################   Part 4.a.  DESCRIPTIVE-STATISTICS ###################
# finds minimum number
# 
# Args : 
#
#    x: data frame
#    minX: stores the minimum value from the data frame x.
#    
# Returns :
# 
# 		minX: it has the minimum value from the given data frame.

findMin <- function(x) {
  minX <- x[1] 
  for (i in (seq_along(x[-1]) + 1)) {
    if(x[i] < minX) 
      minX <- x[i] 
  }
  attr(minX, "class") <- "findMin"
  minX
}

# finds Maximum number
# 
# Args :
# 
#		x: data frame 
# 		MaxX: stores the max value from the data frame
# 
# Returns :
# 
# 		MaxX: maximum value from x.

findMax <- function(x) {
  MaxX <- x[1] 
  for (i in (seq_along(x[-1]) + 1)) {
    if(x[i] > MaxX) 
      MaxX <- x[i]
  }
  attr(MaxX, "class") <- "findMax"
  MaxX
}

# calcuates mode 
# 
# Args: 
# 
# 		countn: maintains count
# 		Storage1: data frame 
# 		Storage2: data frame
# 		Storagemode: mode
#		maxrep: stores max value
# 
# Returns:
#
#		Storagemode: mode value

calmode <- function(x){
  countn <- 0
  Storage1 <- numeric(n)
  Storage2 <- numeric(n)
  for (i in x) {
    for (j in x) {
      if (i == j) {
        countn <- countn +1
      }
      else count <- 1
    }
    Storage1[i] <- countn
    countn <- 0
  }
  maxrep <- findMax(Storage1)
  for(i in 1:100){
    if (Storage1[i] == maxrep)
      Storage2[i] <- i
  }
  Storagemode <- numeric(0)
  for(i in 1:length(x)){
    if (Storage2[i] != 0)
      Storagemode <-  c(Storagemode, Storage2[i])
  }
  attr(Storagemode, "class") <- "calmode"
  Storagemode
}

# sorts data.frame 
#
# Args: 
#
# 	    tempVar: used for swapping while sorting
#		
# Returns:
#
#		x : data frame in sorted form

sortdata <- function(x) {
  tempVar <- 0
  for (i in 1:length(x)){
    for (j in 1:length(x)){
      if (x[i] < x[j]) {
        tempVar <- x[i];
        x[i] <- x[j];
        x[j] <- tempVar;
      }
    }
  }
  x
}

# finds median
#
# Args:
#
#		medianx: median value
#		sortx: sorted data frame
#		m: variable used locally while checking odd or even
#
#	Returns:
#
#		medianx: median value

findmedian <- function(x) {
  medianx <- 0
  sortx <- x
  #  sort
  sortx <- sortdata(x)
  #  check if it is even number
  if (n %% 2 == 0) {
    m <- n/2
    medianx <- (sortx[m]+sortx[(m+1)])/2
  }
  #  check if it is odd number
  else{
    m <- (n+1)/2
    medianx <- sortx[m]
  }
  attr(medianx, "class") <- "findmedian"
  medianx  
}

# calculate mean
#
# Args:
# 
#		sumn: stores the sum value
#		meann: stores mean value
#		
# Returns:
#
#		meann: mean value from data frame

calmean <- function(x){
  sumn <- 0
  meann <- 0
  for (i in x) {
    sumn <- sumn + i
  }
  meann <- sumn / n
  attr(meann, "class") <- "calmean"
  meann
}

# calculate standard deviation
#
# Args:
#
#		sd: store the standard deviation value
#		v: variance
#		m: stored internally to store the mean value returned from the calculate mean function
#
# Returns:
#
#		sd: standard deviation

calsd <- function(x){
  sd <- 0
  v <- 0
  m = calmean(x)
  for (i in 1:length(x)) {
    v <-  v + ((x[i] - m)^2)
  }
  sd <- sqrt(v/(n-1))
  attr(sd, "class") <- "calsd"
  sd
}
###########################   Part 4.b.  Input data randomly distributed  ###################

# gets n  random mumber from r1 to r2
#
# Args:
#
#		n: number of sample
#		r1: start range
#		r2: end range
#		x: saving thedata frame
#		m: minimum value
#		M: max value
#		o: mode value
#		d: median value
#		mu: mean value
#		sigma: standard deviation value

n <-  100 
r1 <- 1   
r2 <- 100 
x <- sample(r1:r2,n,replace=T)


m <- findMin(x)
M <- findMax(x)
o <- calmode(x)
d <- findmedian(x)
mu <- calmean(x)
sigma <- calsd(x)

# prints all the calculated values in the console

print("sample random data set numbers from 1 to 100")
x

print(c("minimum is:", m))

print(c("Maximum is:", M))

print(c("mode is:", o))

print(c("median is:", d))

print(c("mean is:", mu))

print(c("standard deviation is :", sigma))

